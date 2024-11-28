package com.cosmo.galactic_horizons.item;

import com.cosmo.galactic_horizons.GalacticHorizons;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import java.util.function.Supplier;
//7

public enum ModArmorMaterials implements ArmorMaterial {
	ETERNIUM("eternium",false,0,25,15,new int[]  {3,8,6,3},
		SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,2f,0.1f,()-> Ingredient.ofItems(ModItems.RAW_ETERNIUM))
	;
	private final String name;
	private final Boolean glint;
	private final int durabilityMultiplier;
	private final int enchantability;
	private final int[] protectionAmounts;
	private final SoundEvent equipSound;
	private final float toughness;
	private final int speed;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairIngredient;
	private static final int[] BASE_DURIBILITY={11,16,15,13};
	ModArmorMaterials(String name,Boolean glint,int speed, int durabilityMultiplier, int enchantability, int[] protectionAmounts, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.glint = glint;
		this.speed = speed;
		this.durabilityMultiplier = durabilityMultiplier;
		this.enchantability = enchantability;
		this.protectionAmounts = protectionAmounts;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}

	@Override
	public int getDurability(ArmorItem.ArmorSlot slot) {
		return BASE_DURIBILITY[slot.ordinal()]*this.durabilityMultiplier;//it was return BASE_DURIBILITY[slot.ordinal()*this.durabilityMultiplier]
	}
	public Boolean getGlint(){
		return this.glint;
	}
	@Override
	public int getProtection(ArmorItem.ArmorSlot slot) {
		return protectionAmounts[slot.ordinal()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	public int getSpeed() { return this.speed;}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String getName() {
		return GalacticHorizons.MOD_ID+":" + this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
}
