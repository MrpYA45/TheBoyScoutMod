	package com.MrpYA45.TheBoyScoutMod.entity.golems.ai;

import java.util.List;
import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.entity.golems.EntityBaseGolem;
import com.MrpYA45.TheBoyScoutMod.entity.golems.GolemJob;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class HarvestGoal extends Goal {

	private EntityBaseGolem entity;
	private World worldIn;
	private Inventory inv;
	private float speed_modifier = 1.0F;
	private float cooldown = 0;
	private BlockPos target;

	public HarvestGoal(EntityBaseGolem entity) {
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
			if (target != null) {
				if (entity.getNavigator().noPath() && 4 >= entity.getDistanceSq(target.getX(), target.getY(), target.getZ())) {
					worldIn.playSound((PlayerEntity) null, (double) target.getX(), (double) target.getY(), (double) target.getZ(), SoundEvents.BLOCK_CROP_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
					//List<ItemStack> drops = Block.getDrops(worldIn.getBlockState(target), (ServerWorld) worldIn, target, null);
					worldIn.destroyBlock(target, false);
					//for (ItemStack drop : drops)
					//	inv.addItem(drop);
					cooldown = speed_modifier * 6; // 160
					target = null;
					System.out.println("Recolectando");
				} else {
					if (!isValidBlock(target)) {
						resetTask();
					} else {
						this.entity.getNavigator().tryMoveToXYZ(target.getX(), target.getY(), target.getZ(), 1.6F);
					}
				}
			} else {
				System.out.println("Estableciendo target recolectar");
				List<BlockPos> effective_area = entity.getEffectiveArea();
				Random rand = new Random();
				BlockPos pos = effective_area.get(rand.nextInt(effective_area.size())).up();
				if (isValidBlock(pos)) {
					System.out.println("Target recolectar establecido");
					target = pos;
					this.entity.getNavigator().tryMoveToXYZ(target.getX(), target.getY(), target.getZ(), 1.6F);
				}
			}
		}
	}

	private boolean isOnCooldown() {
		return this.cooldown > 0;
	}

	private boolean isValidBlock(BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos);
		return state.getBlock() instanceof CropsBlock && ((CropsBlock) state.getBlock()).isMaxAge(state);
	}

	@Override
	public void resetTask() {
		target = null;
	}
}