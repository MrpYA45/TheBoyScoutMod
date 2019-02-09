package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenTBSMFlowers implements IWorldGenerator {
	
	private int frecuency;
	private Biome[] biomes;
	private WorldGenFlower flower;
	
	public WorldGenTBSMFlowers(Block block, int frecuency, Biome... biomes) {
		this(block, frecuency, 0, biomes);
	}

	public WorldGenTBSMFlowers(Block block, int frecuency, int dimesion, Biome... biomes) {
		
		this.biomes = biomes;
		flower = new WorldGenFlower(block);
		this.frecuency = frecuency;
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		
		Random rand = new Random();
		int x = chunkX * 16 + 8;
		int z = chunkZ * 16 + 8;
		
		Biome biome = world.getBiomeForCoordsBody(new BlockPos(x, 0, z));
		
		boolean isValidBiome = false;
		for(int i = 0; i < biomes.length; i++) {
			if(biome == biomes[i]) {
				isValidBiome = true;
				break;
			}
		}
		
		if(isValidBiome) {
			for(int i = 0; i < frecuency; i++) {
				ChunkPos chunkPos = world.getChunkFromChunkCoords(chunkX, chunkZ).getPos();
				int xPos = rand.nextInt(16) + 8;
				int zPos = rand.nextInt(16) + 8;
				int yPos = rand.nextInt(world.getHeight(chunkPos.getBlock(0, 0, 0).add(xPos, 0, zPos)).getY() + 32);
				BlockPos pos = chunkPos.getBlock(0, 0, 0).add(xPos, yPos, zPos);
				
				flower.generate(world, rand, pos);
			}
		}
	}

}
