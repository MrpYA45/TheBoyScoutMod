package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.Random;
import java.util.function.Function;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class TentFeature extends Feature<NoFeatureConfig> {

	public TentFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn, boolean doBlockNotifyIn) {
		super(configFactoryIn, doBlockNotifyIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		MinecraftServer mcServer = worldIn.getWorld().getServer();
		TemplateManager templateManager = mcServer.getWorld(worldIn.getDimension().getType())
				.getStructureTemplateManager();
		Template template = templateManager.getTemplate(new ResourceLocation(TheBoyScoutMod.MOD_ID, "tent"));
		System.out.println("OLD POS: " + pos.getY());
		pos = pos.down();
		System.out.println("NEW POS: " + pos.getY());
		//if (canSpawnHere(template, worldIn, pos) == false) { System.out.println("CAN SPAWN HERE FALSE\n"); }
		if (template != null && canSpawnHere(template, worldIn, pos)) {
			PlacementSettings settings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(randRot(rand))
					.setIgnoreEntities(false).setChunk(null);
			template.addBlocksToWorldChunk(worldIn, pos, settings);
			//System.out.println("Tent Spawned at: " + pos + "\n");
			return true;
		}
		return false;
	}

	private static int calculateGenerationHeight(IWorld worldIn, int x, int z) {
		int y = worldIn.getHeight();
		boolean foundGround = false;

		while (!foundGround && y-- >= 64) {
			Block block = worldIn.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = block == Blocks.GRASS || block == Blocks.DIRT;
		}

		return y;
	}

	public static boolean canSpawnHere(Template template, IWorld worldIn, BlockPos posAboveGround) {
		int zwidth = template.getSize().getZ();
		int xwidth = template.getSize().getX();

		// check all the corners to see which ones are replaceable
		boolean corner1 = isCornerValid(worldIn, posAboveGround);
		boolean corner2 = isCornerValid(worldIn, posAboveGround.add(xwidth, 0, zwidth));
		boolean middle = isCornerValid(worldIn, posAboveGround.add(xwidth / 2, 0, zwidth / 2));

		// if Y > 64 and all corners pass the test, it's okay to spawn the structure
		return posAboveGround.getY() > 64 && corner1 && corner2 && middle;
	}

	public static boolean isCornerValid(IWorld worldIn, BlockPos pos) {
		int variation = 3;
		int highestBlock = calculateGenerationHeight(worldIn, pos.getX(), pos.getZ());

		if (highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation
				&& noMoreFloatingStructures(worldIn, pos))
			return true;

		return false;
	}

	public static boolean noMoreFloatingStructures(IWorld worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos).getBlock();
		if (block == Blocks.GRASS || block == Blocks.DIRT
				&& worldIn.getBlockState(pos.up()).getBlock().isAir(worldIn.getBlockState(pos.up()), worldIn, pos.up())) {
			return true;
		}
		return false;
	}

	public Rotation randRot(Random rand) {
		int rotation = rand.nextInt(4);
		switch (rotation) {
		case 1:
			return Rotation.CLOCKWISE_180;
		case 2:
			return Rotation.COUNTERCLOCKWISE_90;
		case 3:
			return Rotation.NONE;
		default:
			return Rotation.CLOCKWISE_90;
		}

	}
}
