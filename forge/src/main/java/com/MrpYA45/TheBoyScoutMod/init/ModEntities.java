package com.MrpYA45.TheBoyScoutMod.init;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.EntityFish;
import com.MrpYA45.TheBoyScoutMod.entity.EntityGolem;
import com.MrpYA45.TheBoyScoutMod.entity.EntityPenguin;
import com.MrpYA45.TheBoyScoutMod.entity.EntitySquirrel;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = TheBoyScoutMod.MOD_ID, bus = Bus.MOD)
public class ModEntities {

	public static final EntityType<?> SQUIRREL = EntityType.Builder.create(EntitySquirrel::new, EntityClassification.CREATURE).size(0.2F, 0.6F).build("squirrel").setRegistryName(TheBoyScoutMod.MOD_ID, "squirrel");
	public static final EntityType<?> PENGUIN = EntityType.Builder.create(EntityPenguin::new, EntityClassification.CREATURE).size(0.2F, 0.6F).build("penguin").setRegistryName(TheBoyScoutMod.MOD_ID, "penguin");
	public static final EntityType<?> FISH = EntityType.Builder.create(EntityFish::new, EntityClassification.CREATURE).size(0.2F, 0.2F).build("fish").setRegistryName(TheBoyScoutMod.MOD_ID, "fish");
	public static final EntityType<?> GOLEM = EntityType.Builder.create(EntityGolem::new, EntityClassification.MISC).size(0.5F, 1.0F).build("golem").setRegistryName(TheBoyScoutMod.MOD_ID, "golem");

//	public static void registerEntities() {
//		registerEntity("squirrel", EntitySquirrel.class, Reference.ENTITY_SQUIRREL, 80, (132 << 16) + (68 << 8) + 7, (64 << 16) + (33 << 8) + 3);
//		EntityRegistry.addSpawn(EntitySquirrel.class, 50, 2, 3, EnumCreatureType.CREATURE, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.TAIGA);
//		registerEntity("penguin", EntityPenguin.class, Reference.ENTITY_PENGUIN, 80, (244 << 16) + (239 << 8) + 239, (18 << 16) + (10 << 8) + 10);
//		EntityRegistry.addSpawn(EntityPenguin.class, 50, 5, 12, EnumCreatureType.CREATURE, Biomes.ICE_PLAINS);
//		registerEntity("fish", EntityFish.class, Reference.ENTITY_FISH, 80, (153 << 16) + (153 << 8) + 153, (204 << 16) + (204 << 8) + 255);
//		EntityRegistry.addSpawn(EntityFish.class, 50, 1, 3, EnumCreatureType.WATER_CREATURE, Biomes.RIVER);
//		registerEntity("golem", EntityGolem.class, Reference.ENTITY_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (68 << 16) + (35 << 8) + 5);
//		registerEntity("golem_stone", EntityStoneGolem.class, Reference.ENTITY_STONE_GOLEM, 80, (45 << 16) + (31 << 8) + 6, (126 << 16) + (119 << 8) + 109);
//		registerEntity("golem_iron", EntityIronGolem.class, Reference.ENTITY_IRON_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (194 << 16) + (186 << 8) + 170);
//		registerEntity("golem_gold", EntityGoldGolem.class, Reference.ENTITY_GOLD_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (208 << 16) + (159 << 8) + 46);
//		registerEntity("golem_diamond", EntityDiamondGolem.class, Reference.ENTITY_DIAMOND_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (136 << 16) + (193 << 8) + 188);
//		registerEntity("golem_emerald", EntityEmeraldGolem.class, Reference.ENTITY_EMERALD_GOLEM, 80, (43 << 16) + (29 << 8) + 6, (10 << 16) + (149 << 8) + 98);
//	}

	@Mod.EventBusSubscriber(modid = TheBoyScoutMod.MOD_ID, bus = Bus.MOD)
	public static class Register {

		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event) {
			final EntityType<?>[] entity = {
					SQUIRREL,
					PENGUIN,
					FISH,
					GOLEM
			};

			event.getRegistry().registerAll(entity);
		}
	}

}
