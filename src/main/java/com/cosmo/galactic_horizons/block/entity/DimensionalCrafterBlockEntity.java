package com.cosmo.galactic_horizons.block.entity;

import com.cosmo.galactic_horizons.effect.ModEffects;
import com.cosmo.galactic_horizons.potion.ModPotions;
import com.cosmo.galactic_horizons.screen.DimensionalCrafterScreen;
import com.cosmo.galactic_horizons.screen.DimensionalCrafterScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DimensionalCrafterBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory,ImplementedInventory{
	private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(6,ItemStack.EMPTY);

	private static final int INPUT_SLOT = 0;
	private static final int INPUT_SLOT1 = 1;
	private static final int INPUT_SLOT2 = 4;
	private static final int INPUT_SLOT3 = 3;
	private static final int CENTER_SLOT = 2;
	private static final int OUTPUT_SLOT = 5;

	public final PropertyDelegate propertyDelegate;
	private int progress = 0;
	private int maxProgress = 72;
	public int dimension;

	public DimensionalCrafterBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.DIMENSIONAL_CRAFTER_BLOCK_ENTITY, pos, state);

		this.propertyDelegate = new PropertyDelegate() {
			@Override
			public int get(int index) {
				return switch (index){
					case 0 -> DimensionalCrafterBlockEntity.this.progress;
					case 1 -> DimensionalCrafterBlockEntity.this.maxProgress;
					case 2 -> DimensionalCrafterBlockEntity.this.dimension;
					default -> 0;
				};
			}

			@Override
			public void set(int index, int value) {
				switch (index) {
					case 0 -> DimensionalCrafterBlockEntity.this.progress = value;
					case 1 -> DimensionalCrafterBlockEntity.this.maxProgress = value;
					case 2 -> DimensionalCrafterBlockEntity.this.dimension = value;
				}
			}
			@Override
			public int size() {
				return 2;
			}
		};
	}

	@Override
	public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
		buf.writeBlockPos(this.pos);
	}

	@Override
	public Text getDisplayName() {
		return Text.literal("Dimensional Crafter");
	}

	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		Inventories.writeNbt(nbt,inventory);
		nbt.putInt("dimensional_crafter_progress",progress);
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		Inventories.readNbt(nbt,inventory);
		progress = nbt.getInt("dimensional_crafter_progress");
	}

	@Nullable
	@Override
	public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
		return new DimensionalCrafterScreenHandler(i,playerInventory, (BlockEntity) this, this.propertyDelegate, ScreenHandlerContext.create(world,pos));
	}
	public void tick(World world, BlockPos pos, BlockState state){
		if(world.isClient()) {
			return;
		}
		if(this.getStack(INPUT_SLOT).getItem() == Items.DIRT){
			dimension = 1;
		}
		if(isOutputSlotEmptyOrReceivable()){
			if(this.hasRecipe()){
				this.increaceCraftProgress();
				markDirty(world, pos, state);

				if(hasCraftingFinished()){
					this.craftItem();
					this.resetProgress();
				}
			}else {
				this.resetProgress();
			}
		} else {
			this.resetProgress();
			markDirty(world, pos, state);
		}

	}

	private void resetProgress() {
		this.progress = 0;
	}

	private void craftItem() {
		this.removeStack(INPUT_SLOT,1);
		this.removeStack(INPUT_SLOT1,1);
		this.removeStack(INPUT_SLOT2,1);
		this.removeStack(INPUT_SLOT3,1);
		this.removeStack(CENTER_SLOT,1);
		ItemStack result = new ItemStack(Items.BARRIER);

		this.setStack(OUTPUT_SLOT,new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
	}

	private boolean hasCraftingFinished() {
		return progress >= maxProgress;
	}

	private void increaceCraftProgress() {
		progress++;
	}

	private boolean hasRecipe() {
		ItemStack result = new ItemStack(Items.BARRIER);
		System.out.println(this.dimension);
		boolean hasInput = getStack(INPUT_SLOT).getItem() == Items.DIRT && getStack(INPUT_SLOT1).getItem() == Items.DIRT && getStack(INPUT_SLOT2).isEmpty() && getStack(INPUT_SLOT3).isEmpty() && getStack(CENTER_SLOT).getItem() == Items.DIRT;
		return this.dimension == 1&&hasInput && canInsertAmountIntoOutputSlot(result) && canInserItemIntoOutputSlot(result.getItem());
	}
	private boolean canInserItemIntoOutputSlot(Item item) {
		return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
	}

	private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
		return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
	}
	private boolean isOutputSlotEmptyOrReceivable() {
		return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
	}
	@Override
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}
	public void setDimension(int value) {
		this.propertyDelegate.set(2,value);
	}
}
