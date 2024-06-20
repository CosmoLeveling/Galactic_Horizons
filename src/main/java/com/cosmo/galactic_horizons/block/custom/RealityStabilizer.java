package com.cosmo.galactic_horizons.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class RealityStabilizer extends Block {
	private static final VoxelShape SHAPE = Block.createCuboidShape(6.5,0,6.5,9.5,5,9.5);

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return SHAPE;
	}

	public RealityStabilizer(Settings settings) {
		super(settings);
	}
}
