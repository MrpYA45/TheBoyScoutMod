package com.MrpYA45.TheBoyScoutMod.worldgen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenTBSM {
	
	public static void setup() {

		for(Biome biome : ForgeRegistries.BIOMES) {
			biome.addFeature(Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new TBSMFlowersFeature(NoFeatureConfig::deserialize), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(2)));
			if (biome.getCategory().equals(Biome.Category.FOREST)) {
				biome.addFeature(Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new HazelTreeFeature(), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_EXTRA_HEIGHTMAP, new AtSurfaceWithExtraConfig(1, 0.1F, 1)));
			}
			if (biome.getCategory().equals(Biome.Category.PLAINS)) {
				biome.addFeature(Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(new TentFeature(NoFeatureConfig::deserialize, false), IFeatureConfig.NO_FEATURE_CONFIG, Placement.CHANCE_HEIGHTMAP, new ChanceConfig(10)));
			}
		}
	}

}