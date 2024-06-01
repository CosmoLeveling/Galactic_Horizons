package com.cosmo.galactic_horizons.screen;

import com.cosmo.galactic_horizons.block.entity.DimensionalCrafterBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class DimensionalCrafterScreenHandler extends ScreenHandler {
	private final Inventory inventory;
	private final PropertyDelegate propertyDelegate;
	public final DimensionalCrafterBlockEntity blockEntity;

	public DimensionalCrafterScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf){
		this(syncId,inventory,inventory.player.getWorld().getBlockEntity(buf.readBlockPos()),
			new ArrayPropertyDelegate(2));
	}

	public DimensionalCrafterScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
		super(ModScreenHandler.DIMENSIONAL_CRAFTER_SCREEN_HANDLER_SCREEN,syncId);
		checkSize((Inventory) blockEntity,2);
		this.inventory = (Inventory) blockEntity;
		playerInventory.onOpen(playerInventory.player);
		this.propertyDelegate = arrayPropertyDelegate;
		this.blockEntity = (DimensionalCrafterBlockEntity) blockEntity;

		this.addSlot(new Slot(inventory,0,77,34));
		this.addSlot(new Slot(inventory,1,58,15));
		this.addSlot(new Slot(inventory,2,58,34));
		this.addSlot(new Slot(inventory,3,58,53));
		this.addSlot(new Slot(inventory,4,39,34));
		this.addSlot(new Slot(inventory,5,123,34));


		addPlayerHotbar(playerInventory);
		addPlayerInventory(playerInventory);

		addProperties(arrayPropertyDelegate);
	}

	public boolean isCrafting() {
		return propertyDelegate.get(0) > 0;
	}
	public int getScaledProgress() {
		int progress = this.propertyDelegate.get(0);
		int maxProgress = this.propertyDelegate.get(1);  // Max Progress
		int progressArrowSize = 20; // This is the width in pixels of your arrow

		return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
	}
	@Override
	public ItemStack quickTransfer(PlayerEntity player, int invSlot) {
		ItemStack newStack = ItemStack.EMPTY;
		Slot slot = this.slots.get(invSlot);
		if (slot != null && slot.hasStack()) {
			ItemStack originalStack = slot.getStack();
			newStack = originalStack.copy();
			if (invSlot < this.inventory.size()) {
				if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
				return ItemStack.EMPTY;
			}

			if (originalStack.isEmpty()) {
				slot.setStack(ItemStack.EMPTY);
			} else {
				slot.markDirty();
			}
		}

		return newStack;
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}

	private void addPlayerInventory(PlayerInventory playerInventory) {
		for (int i = 0; i < 3; ++i) {
			for (int l = 0; l < 9; ++l) {
				this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
			}
		}
	}

	private void addPlayerHotbar(PlayerInventory playerInventory) {
		for (int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
		}
	}
}
