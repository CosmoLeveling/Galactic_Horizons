package com.cosmo.galactic_horizons.networking.packet;

import com.cosmo.galactic_horizons.GalacticHorizonsClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import org.quiltmc.qsl.networking.api.PacketSender;

public class SplitUpdateS2CPacket {
	public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
							   PacketByteBuf buf, PacketSender responseSender) {
			GalacticHorizonsClient.entities.add(buf.readUuid());
	}
}
