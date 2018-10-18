package com.MrpYA45.TheBoyScoutMod.init;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.entity.EntityDiamondGolem;
import com.MrpYA45.TheBoyScoutMod.entity.EntityEmeraldGolem;
import com.MrpYA45.TheBoyScoutMod.entity.EntityFish;
import com.MrpYA45.TheBoyScoutMod.entity.EntityGoldGolem;
import com.MrpYA45.TheBoyScoutMod.entity.EntityGolem;
import com.MrpYA45.TheBoyScoutMod.entity.EntityIronGolem;
import com.MrpYA45.TheBoyScoutMod.entity.EntityPenguin;
import com.MrpYA45.TheBoyScoutMod.entity.EntitySquirrel;
import com.MrpYA45.TheBoyScoutMod.entity.EntityStoneGolem;
import com.MrpYA45.TheBoyScoutMod.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	public static void registerEntities() {
		registerEntity("squirrel", EntitySquirrel.class, Reference.ENTITY_SQUIRREL, 80, (132 << 16) + (68 << 8) + 7, (64 << 16) + (33 << 8) + 3);
		EntityRegistry.addSpawn(EntitySquirrel.class, 50, 2, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.TAIGA);
		registerEntity("penguin", EntityPenguin.class, Reference.ENTITY_PENGUIN, 80, (244 << 16) + (239 << 8) + 239, (18 << 16) + (10 << 8) + 10);
		EntityRegistry.addSpawn(EntityPenguin.class, 50, 5, 12, EnumCreatureType.CREATURE, Biomes.ICE_PLAINS);
		registerEntity("fish", EntityFish.class, Reference.ENTITY_FISH, 80, (153 << 16) + (153 << 8) + 153, (204 << 16) + (204 << 8) + 255);
		EntityRegistry.addSpawn(EntityFish.class, 50, 1, 3, EnumCreatureType.WATER_CREATURE, Biomes.RIVER);
		registerEntity("golem", EntityGolem.class, Reference.ENTITY_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (68 << 16) + (35 << 8) + 5);
		registerEntity("golem_stone", EntityStoneGolem.class, Reference.ENTITY_STONE_GOLEM, 80, (45 << 16) + (31 << 8) + 6, (126 << 16) + (119 << 8) + 109);
		registerEntity("golem_iron", EntityIronGolem.class, Reference.ENTITY_IRON_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (194 << 16) + (186 << 8) + 170);
		registerEntity("golem_gold", EntityGoldGolem.class, Reference.ENTITY_GOLD_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (208 << 16) + (159 << 8) + 46);
		registerEntity("golem_diamond", EntityDiamondGolem.class, Reference.ENTITY_DIAMOND_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (136 << 16) + (193 << 8) + 188);
		registerEntity("golem_emerald", EntityEmeraldGolem.class, Reference.ENTITY_EMERALD_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (10 << 16) + (149 << 8) + 98);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 3, true, color1, color2);
	}

}
