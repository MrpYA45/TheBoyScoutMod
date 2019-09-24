package com.MrpYA45.TheBoyScoutMod.worldgen;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.util.TBSMConfig;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenOreGen {

	public static void setup() {
		for (Biome biome : ForgeRegistries.BIOMES) {

			CountRangeConfig placementConfig = new CountRangeConfig(TBSMConfig.Server.bluepowderfrecuency.get(), 48, 96, 256);

			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.BLUE_POWDER_GRAVEL_BLOCK.getDefaultState(), 16), Placement.COUNT_RANGE, placementConfig)); 
		}
	}

}