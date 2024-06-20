package com.cosmo.galactic_horizons.item.custom;

import com.cosmo.galactic_horizons.item.ModArmorMaterials;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;

import java.util.UUID;

public class ModArmorItem extends ArmorItem {
	private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
	public ModArmorItem(ModArmorMaterials material, ArmorSlot slot, Settings settings ){
		super(material, slot, settings);
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		builder.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.randomUUID(), "Armor modifier", material.getSpeed(), EntityAttributeModifier.Operation.MULTIPLY_BASE));
		builder.put(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(UUID.randomUUID(), "Armor modifier", getToughness(), EntityAttributeModifier.Operation.ADDITION));
		builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.randomUUID(), "Armor modifier", getProtection(), EntityAttributeModifier.Operation.ADDITION));
		builder.put(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(UUID.randomUUID(), "Armor modifier", getMaterial().getKnockbackResistance(), EntityAttributeModifier.Operation.ADDITION));
		this.attributeModifiers = builder.build();

	}
	@Override
	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		return slot == this.armorSlot.getEquipmentSlot() ? this.attributeModifiers : super.getAttributeModifiers(slot);
	}
}
