package com.MrpYA45.TheBoyScoutMod.blocks;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReaderBase;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class BlockRope extends Block {

	public BlockRope() {
		super(Properties.create(Material.CLOTH).sound(SoundType.CLOTH));
		setRegistryName("rope_block");
	}

	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.PICKAXE;
	}

	public boolean isValidPosition(IBlockState state, IWorldReaderBase worldIn, BlockPos pos) {
		return this.canAttachTo(worldIn, pos.up());
	}

	private boolean canAttachTo(IWorldReaderBase worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		boolean flag = isExceptBlockForAttachWithPiston(iblockstate.getBlock());
		return (!flag && iblockstate.getBlockFaceShape(worldIn, pos, EnumFacing.DOWN) == BlockFaceShape.SOLID
				&& !iblockstate.canProvidePower()) || iblockstate.getBlock() instanceof BlockRope;
	}

	public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState,
			IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (!stateIn.isValidPosition(worldIn, currentPos)) {
			return Blocks.AIR.getDefaultState();
		} else {
			return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		}
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
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

//	@Override
//	public boolean isLadder(IBlockState state, IWorldReader world, BlockPos pos, EntityLivingBase entity) {
//		return true;
//	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		return Block.makeCuboidShape(6.0F, 0.0F, 6.0F, 10.0F, 16F, 10.0F);
	}

	@Override
	public void onEntityCollision(IBlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (entityIn instanceof EntityPlayer) {
			if (entityIn.motionY >= 0.1) {
				if (worldIn.getBlockState(pos.add(0, 2, 0)).getBlock().equals(ModBlocks.ROPE_BLOCK)) {
					entityIn.setPosition(entityIn.posX, entityIn.posY + 0.2F, entityIn.posZ);
				}
			}
		}
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}
}