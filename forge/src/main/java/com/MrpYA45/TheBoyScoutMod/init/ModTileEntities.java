package com.MrpYA45.TheBoyScoutMod.init;

import static com.MrpYA45.TheBoyScoutMod.util.InjectionUtil.Null;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityDiamondBox;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityGoldBox;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityIronBox;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityPaperBin;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityWoodenBox;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TheBoyScoutMod.MOD_ID)
public class ModTileEntities {

	public static final TileEntityType<TileEntityWoodenBox> WOODEN_BOX = Null();
	public static final TileEntityType<TileEntityIronBox> IRON_BOX = Null();
	public static final TileEntityType<TileEntityGoldBox> GOLD_BOX = Null();
	public static final TileEntityType<TileEntityDiamondBox> DIAMOND_BOX = Null();
	public static final TileEntityType<TileEntityEmeraldBox> EMERALD_BOX = Null();
	public static final TileEntityType<TileEntityPaperBin> PAPER_BIN = Null();

	@Mod.EventBusSubscriber(modid = TheBoyScoutMod.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
			final TileEntityType<?>[] tile_entities = {
					TileEntityType.Builder.create(TileEntityWoodenBox::new, ModBlocks.WOODEN_BOX_BLOCK).build(null).setRegistryName(TheBoyScoutMod.MOD_ID, "wooden_box"),
					TileEntityType.Builder.create(TileEntityIronBox::new, ModBlocks.IRON_BOX_BLOCK).build(null).setRegistryName(TheBoyScoutMod.MOD_ID, "iron_box"),
					TileEntityType.Builder.create(TileEntityGoldBox::new, ModBlocks.GOLD_BOX_BLOCK).build(null).setRegistryName(TheBoyScoutMod.MOD_ID, "gold_box"),
					TileEntityType.Builder.create(TileEntityDiamondBox::new, ModBlocks.DIAMOND_BOX_BLOCK).build(null).setRegistryName(TheBoyScoutMod.MOD_ID, "diamond_box"),
					TileEntityType.Builder.create(TileEntityEmeraldBox::new, ModBlocks.EMERALD_BOX_BLOCK).build(null).setRegistryName(TheBoyScoutMod.MOD_ID, "emerald_box"),
					TileEntityType.Builder.create(TileEntityPaperBin::new, ModBlocks.PAPER_BIN_BLOCK).build(null).setRegistryName(TheBoyScoutMod.MOD_ID, "paper_bin")
			};
			
			event.getRegistry().registerAll(tile_entities);
		}
	}

}
