package com.MrpYA45.TheBoyScoutMod.blocks;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class BlockRope extends Block {

	public BlockRope() {
		super(Properties.create(Material.WOOL).sound(SoundType.CLOTH));
		setRegistryName("rope_block");
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return this.canAttachTo(worldIn, pos.up());
	}

	private boolean canAttachTo(IBlockReader worldIn, BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos);
		return (!state.canProvidePower() && Block.hasSolidSide(state, worldIn, pos, Direction.DOWN))
				|| state.getBlock() instanceof BlockRope;
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		if (!stateIn.isValidPosition(worldIn, currentPos)) {
			return Blocks.AIR.getDefaultState();
		} else {
			return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		}
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			if (getBlockFromItem(player.inventory.getCurrentItem().getItem()).equals(ModBlocks.ROPE_BLOCK)) {
				int y = 0;
				do {
					y++;
				} while (worldIn.getBlockState(pos.down(y)).getBlock().equals(ModBlocks.ROPE_BLOCK));
				if (worldIn.getBlockState(pos.down(y)).getMaterial().isReplaceable() && pos.down(y).getY() >= 0
						&& !worldIn.getBlockState(pos.down(y)).getMaterial().isLiquid()
						&& !worldIn.getBlockState(pos.down(y)).getMaterial().equals(Material.SEA_GRASS)) {
					if (!player.isCreative()) {
						player.inventory.getCurrentItem().shrink(1);
					}
					worldIn.destroyBlock(pos.down(y), true);
					worldIn.setBlockState(pos.down(y), this.getDefaultState());
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
		return true;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);
	}

	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof PlayerEntity) {
			if (entityIn.getMotion().getY() >= 0.1) {
				if (worldIn.getBlockState(pos.add(0, 2, 0)).getBlock().equals(ModBlocks.ROPE_BLOCK)) {
					entityIn.setPosition(entityIn.posX, entityIn.posY + 0.2F, entityIn.posZ);
				}
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
}
