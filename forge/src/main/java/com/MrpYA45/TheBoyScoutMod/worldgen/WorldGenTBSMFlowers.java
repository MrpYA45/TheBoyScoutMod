package com.MrpYA45.TheBoyScoutMod.worldgen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.CompositeFlowerFeature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.SurfacePlus32;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenTBSMFlowers {
	
	public static void setup() {
		for(Biome biome : ForgeRegistries.BIOMES) {
			biome.addFeature(Decoration.VEGETAL_DECORATION, new CompositeFlowerFeature<>(new TBSMFlowersFeature(), new SurfacePlus32(), new FrequencyConfig(2)));
		}
	}

}