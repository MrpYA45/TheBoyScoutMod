package com.MrpYA45.TheBoyScoutMod.entity.golems.ai;

import java.util.List;
import java.util.Map;
import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.entity.golems.EntityBaseGolem;
import com.MrpYA45.TheBoyScoutMod.entity.golems.GolemJob;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlowGoal extends Goal {

	protected static final Map<Block, BlockState> PLOWABLE_BLOCK = Maps.newHashMap(ImmutableMap.of(Blocks.GRASS_BLOCK,
			Blocks.FARMLAND.getDefaultState(), Blocks.GRASS_PATH, Blocks.FARMLAND.getDefaultState(), Blocks.DIRT,
			Blocks.FARMLAND.getDefaultState(), Blocks.COARSE_DIRT, Blocks.DIRT.getDefaultState()));

	private EntityBaseGolem entity;
	private World worldIn;
	private Inventory inv;
	private float speed_modifier = 1.0F;
	private float cooldown = 0;
	private BlockPos target;

	public PlowGoal(EntityBaseGolem entity) {
		this.entity = entity;
		worldIn = entity.getEntityWorld();
		inv = entity.getInventory();
	}

	@Override
	public boolean shouldExecute() {
		if (!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(worldIn, entity)) {
			return false;
		} else if (entity.getJob() != GolemJob.FARMER) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void tick() {
		if (isOnCooldown()) {
			cooldown--;
		} else {
			BlockState blockstate;
			if (target != null) {
				blockstate = PLOWABLE_BLOCK.get(worldIn.getBlockState(target.down()).getBlock());
				if (entity.getNavigator().noPath() && 4 >= entity.getDistanceSq(target.getX(), target.getY(), target.getZ())) {
					worldIn.playSound((PlayerEntity) null, (double) target.getX(), (double) target.getY(), (double) target.getZ(), SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlockState(target.down(), blockstate, 11);
					cooldown = speed_modifier * 6; // 160
					entity.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.WHEAT_SEEDS));
					worldIn.playSound((PlayerEntity) null, (double) target.getX(), (double) target.getY(), (double) target.getZ(), SoundEvents.ITEM_CROP_PLANT, SoundCategory.BLOCKS, 1.0F, 1.0F);
					worldIn.setBlockState(target, Blocks.WHEAT.getDefaultState());
					target = null;
					System.out.println("Plantando");
				} else {
					if (blockstate == null) {
						resetTask();
					} else {
						this.entity.getNavigator().tryMoveToXYZ(target.getX(), target.getY(), target.getZ(), 1.6F);
					}
				}
			} else {
				System.out.println("Estableciendo target");
				List<BlockPos> effective_area = entity.getEffectiveArea();
				Random rand = new Random();
				BlockPos pos = effective_area.get(rand.nextInt(effective_area.size()));
				blockstate = PLOWABLE_BLOCK.get(worldIn.getBlockState(pos).getBlock());
				if (blockstate != null) {
					System.out.println("Target establecido");
					target = pos.up();
					this.entity.getNavigator().tryMoveToXYZ(target.getX(), target.getY(), target.getZ(), 1.6F);
					entity.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_HOE));
				}
			}
		}
	}

	private boolean isOnCooldown() {
		return this.cooldown > 0;
	}

	@Override
	public void resetTask() {
		target = null;
	}
}