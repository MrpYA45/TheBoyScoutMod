package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomStructures implements IWorldGenerator {
	
	public static final WorldGenStructure CAMPFIRE = new WorldGenStructure("campfire");
	public static final WorldGenStructure PILE_OF_LOGS = new WorldGenStructure("pile_of_logs");
	public static final WorldGenStructure VIGILANCE_TOWER = new WorldGenStructure("vigilance_tower");
	public static final WorldGenStructure TENT = new WorldGenStructure("tent");
	public static final WorldGenStructure FORT = new WorldGenStructure("fort");
	public static final WorldGenStructure HAZEL_TREE = new WorldGenStructure("hazel_tree");
	public static final WorldGenStructure PALM_TREE = new WorldGenStructure("palm_tree");

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension()) {
		case 1:
			break;
		case 0:
			
			generateStructure(CAMPFIRE, world, random, chunkX, chunkZ, 98, BiomeForest.class, BiomePlains.class);
			generateStructure(PILE_OF_LOGS, world, random, chunkX, chunkZ, 98, BiomeForest.class, BiomePlains.class);
			generateStructure(VIGILANCE_TOWER, world, random, chunkX, chunkZ, 98, BiomeForest.class);
			generateStructure(TENT, world, random, chunkX, chunkZ, 98, BiomeForest.class, BiomePlains.class);
			generateStructure(FORT, world, random, chunkX, chunkZ, 98, BiomeForest.class);
			generateStructure(HAZEL_TREE, world, random, chunkX, chunkZ, 10, BiomeForest.class, BiomePlains.class);
			generateStructure(PALM_TREE, world, random, chunkX, chunkZ, 20, BiomeDesert.class, BiomeBeach.class);
			
			break;
		case -1:
			break;
		}		
	}
	
	private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Class<?>... classes) {
		
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int x = chunkX * 16 + 4 + random.nextInt(9);
		int z = chunkZ * 16 + 4 + random.nextInt(9);
		int y = calculateGenerationHeight(world, x, z);
		BlockPos pos = new BlockPos(x,y,z);
		
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		
		if(world.getWorldType() != WorldType.FLAT) {
			if(classesList.contains(biome)) {
				if(random.nextInt(chance) == 0) {
					generator.generate(world, random, pos);
				}
			}
		}
	}
	
	private static int calculateGenerationHeight(World world, int x, int z) {
		int y = world.getHeight();
		boolean foundGround = false;
		
		while(!foundGround && y-- >= 64) {
			Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = block == Blocks.GRASS||block == Blocks.DIRT||block == Blocks.SAND;
		}
		
		return y;
	}

	public static boolean canSpawnHere(Template template, World world, BlockPos posAboveGround) {
		int zwidth = template.getSize().getZ();
		int xwidth = template.getSize().getX();
		
		// check all the corners to see which ones are replaceable
		boolean corner1 = isCornerValid(world, posAboveGround);
		boolean corner2 = isCornerValid(world, posAboveGround.add(xwidth, 0, zwidth));
		boolean middle = isCornerValid(world, posAboveGround.add(xwidth/2, 0, zwidth/2));
	
		// if Y > 64 and all corners pass the test, it's okay to spawn the structure
		return posAboveGround.getY() > 64 && corner1 && corner2 && middle;
	}

	public static boolean isCornerValid(World world, BlockPos pos) {
		int variation = 3;
		int highestBlock = calculateGenerationHeight(world, pos.getX(), pos.getZ());
	
		if (highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation && noMoreFloatingStructures(world, pos))
			return true;
			
		return false;
	}
	
	public static boolean noMoreFloatingStructures(World world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();
		if(block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.SAND) {
			return true;
		}
		return false;
	}
}
