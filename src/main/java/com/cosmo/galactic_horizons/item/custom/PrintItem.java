package com.cosmo.galactic_horizons.item.custom;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PrintItem extends Item {
	public PrintItem(Settings settings) {
		super(settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.setVelocity((attacker.getX()-target.getX())/5,(attacker.getY()-target.getY())/5,(attacker.getZ()-target.getZ())/5);
		return super.postHit(stack, target, attacker);
	}
}
