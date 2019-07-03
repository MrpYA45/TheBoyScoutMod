package com.MrpYA45.TheBoyScoutMod.worldgen;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.util.TBSMConfig;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGenOreGen {

	public static void setup() {
		for (Biome biome : ForgeRegistries.BIOMES) {

			CountRangeConfig placementConfig = new CountRangeConfig(TBSMConfig.Server.bluepowderfrecuency.get(), 48, 96, 256);

			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, ModBlocks.BLUE_POWDER_GRAVEL_BLOCK.getDefaultState(), 16), new CountRange(), placementConfig));
		}
	}

}