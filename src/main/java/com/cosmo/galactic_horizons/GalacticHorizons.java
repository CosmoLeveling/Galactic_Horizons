package com.cosmo.galactic_horizons;

import com.cosmo.galactic_horizons.block.ModBlocks;
import com.cosmo.galactic_horizons.effect.ModEffects;
import com.cosmo.galactic_horizons.networking.ModMessages;
import com.cosmo.galactic_horizons.particle.ModParticles;
import com.cosmo.galactic_horizons.potion.ModPotions;
import ladysnake.satin.api.event.ShaderEffectRenderCallback;
import ladysnake.satin.api.managed.ManagedShaderEffect;
import ladysnake.satin.api.managed.ShaderEffectManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.entity.event.api.ServerEntityLoadEvents;
import org.quiltmc.qsl.networking.api.PacketByteBufs;
import org.quiltmc.qsl.networking.api.ServerPlayConnectionEvents;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.UUID;

public class GalacticHorizons implements ModInitializer {
    public static HashSet<UUID> livingEntities = new HashSet<>();
	public static final Logger LOGGER = LoggerFactory.getLogger("Galactic Horizons");
	public static final String MOD_ID = "galactic_horizons";
	public static Identifier id(String path) {
		return new Identifier(MOD_ID,path);
	}

    @Override
    public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}! Stay fresh!", mod.metadata().name());
		ModEffects.registerEffects();
		ModBlocks.registerModBlocks();
		ModPotions.registerPotions();
		ModParticles.registerParticles();
		ModMessages.registerC2SPackets();
		ServerPlayConnectionEvents.JOIN.register(((handler, sender, server) ->
		{
			if(server != null){
				PacketByteBuf buf = PacketByteBufs.create();
				buf.writeCollection(livingEntities,PacketByteBuf::writeUuid);
				ServerPlayNetworking.send(handler.getPlayer(),ModMessages.INVISIBILITY_JOIN_UPDATE_PACKET_ID,buf);
			}
		}));
		ServerEntityLoadEvents.AFTER_LOAD.register((entity, world) -> {
			if(entity instanceof LivingEntity livingEntity && livingEntity.hasStatusEffect(ModEffects.SPLIT)&&entity.getServer()!=null){
				PacketByteBuf buf = PacketByteBufs.create();
				buf.writeUuid(livingEntity.getUuid());
				livingEntities.add(livingEntity.getUuid());
				entity.getServer().getPlayerManager().sendToAll(ServerPlayNetworking.createS2CPacket(ModMessages.INVISIBILITY_LOAD_UPDATE_PACKET_ID,buf));
			}
		});
	}
}
