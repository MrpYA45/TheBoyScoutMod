package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOreGen implements IWorldGenerator {

	//World Generator
	private WorldGenerator blue_powder_gravel_overworld;
	
	public WorldGenCustomOreGen() {
		blue_powder_gravel_overworld = new WorldGenMinable(ModBlocks.BLUE_POWDER_GRAVEL_BLOCK.getDefaultState(), 16);
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i ++) {
			int x = chunk_X * 16 + rand.nextInt(16);
		        int y = minHeight + rand.nextInt(heightDiff);
		        int z = chunk_Z * 16 + rand.nextInt(16);
		        generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		switch(world.provider.getDimension())
		{
		case 0: //Overworld
			this.runGenerator(blue_powder_gravel_overworld, world, random, chunkX, chunkZ, 50, 48, 96);
			break;
		case -1: //Nether
			break;
		case 1: //TheEnd
		}
	}

}
