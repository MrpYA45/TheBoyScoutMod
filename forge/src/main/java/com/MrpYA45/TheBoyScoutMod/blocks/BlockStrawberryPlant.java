package com.MrpYA45.TheBoyScoutMod.blocks;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockStrawberryPlant extends BlockCrops {

	public BlockStrawberryPlant(String name) {
		super(Properties.create(Material.PLANTS).doesNotBlockMovement().needsRandomTick().hardnessAndResistance(0.0F).sound(SoundType.PLANT));
		setRegistryName(name);
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			if (this.isMaxAge(state)) {
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(),
						new ItemStack(ModItems.STRAWBERRY, new Random().nextInt(2) + 1)));
				worldIn.setBlockState(pos, this.withAge(3));
				return true;
			}
		}
		return false;
	}

	@Override
	protected IItemProvider getSeedsItem() {
		return ModItems.STRAWBERRY;
	}

	@Override
	protected IItemProvider getCropsItem() {
		return ModItems.STRAWBERRY;
	}

}