package com.MrpYA45.TheBoyScoutMod.blocks.boxes;

import com.MrpYA45.TheBoyScoutMod.blocks.BlockBase;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

public abstract class BlockAbstractBox extends BlockBase {

	public BlockAbstractBox(String name) {
		super(name, Material.WOOD, 2.0F, 15.0F, SoundType.WOOD); // TODO Cambiar valores resistencia
	}

	@Override
	public abstract boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit);

	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if(state.hasTileEntity() && state.getBlock() != newState.getBlock()) {
			worldIn.getTileEntity(pos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
				for(int i = 0; i < h.getSlots(); i++) {
					spawnAsEntity(worldIn, pos, h.getStackInSlot(i));
				}
			});
			worldIn.removeTileEntity(pos);
		}
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public abstract TileEntity createTileEntity(BlockState state, IBlockReader world);

}