package com.cosmo.galactic_horizons;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;

public interface PlayerDamageCallback {
	Event<PlayerDamageCallback> EVENT = EventFactory.createArrayBacked(PlayerDamageCallback.class, (listeners) -> (player, source, amount) -> {
		for(var listener : listeners) {
			var result = listener.invoke(player, source, amount);

			if(result != ActionResult.PASS) {
				return result;
			}
		}

		return ActionResult.PASS;
	});

	ActionResult invoke(ServerPlayerEntity player, DamageSource source, float amount);
}
