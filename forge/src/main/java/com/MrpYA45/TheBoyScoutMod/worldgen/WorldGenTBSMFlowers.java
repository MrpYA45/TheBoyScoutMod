package com.MrpYA45.TheBoyScoutMod.worldgen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenTBSMFlowers {
	
	public static void setup() {

		for(Biome biome : ForgeRegistries.BIOMES) {
			biome.addFeature(Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(new TBSMFlowersFeature(NoFeatureConfig::deserialize), IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(2)));
		}
	}

}