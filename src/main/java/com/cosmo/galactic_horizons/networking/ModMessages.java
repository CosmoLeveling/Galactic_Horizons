package com.cosmo.galactic_horizons.networking;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.networking.packet.SplitJoinUpdateS2CPacket;
import com.cosmo.galactic_horizons.networking.packet.SplitLoadUpdateS2CPacket;
import com.cosmo.galactic_horizons.networking.packet.SplitRemoveUpdateS2CPacket;
import com.cosmo.galactic_horizons.networking.packet.SplitUpdateS2CPacket;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.networking.api.ServerPlayNetworking;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

public class ModMessages {
	public static final Identifier INVISIBILITY_UPDATE_PACKET_ID = new Identifier(GalacticHorizons.MOD_ID, "invisibility_update");
	public static final Identifier INVISIBILITY_JOIN_UPDATE_PACKET_ID = new Identifier(GalacticHorizons.MOD_ID, "invisibility_join_update");
	public static final Identifier INVISIBILITY_REMOVE_UPDATE_PACKET_ID = new Identifier(GalacticHorizons.MOD_ID, "invisibility_remove_update");
	public static final Identifier INVISIBILITY_LOAD_UPDATE_PACKET_ID = new Identifier(GalacticHorizons.MOD_ID,"invisibility_load_update");
	public static void registerC2SPackets() {
	}

	public static void registerS2CPackets() {
		ClientPlayNetworking.registerGlobalReceiver(INVISIBILITY_UPDATE_PACKET_ID, SplitUpdateS2CPacket::receive);
		ClientPlayNetworking.registerGlobalReceiver(INVISIBILITY_JOIN_UPDATE_PACKET_ID, SplitJoinUpdateS2CPacket::receive);
		ClientPlayNetworking.registerGlobalReceiver(INVISIBILITY_REMOVE_UPDATE_PACKET_ID, SplitRemoveUpdateS2CPacket::receive);
		ClientPlayNetworking.registerGlobalReceiver(INVISIBILITY_LOAD_UPDATE_PACKET_ID, SplitLoadUpdateS2CPacket::receive);
	}
}
