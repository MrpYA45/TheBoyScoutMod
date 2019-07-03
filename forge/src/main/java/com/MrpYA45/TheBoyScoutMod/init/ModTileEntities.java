package com.MrpYA45.TheBoyScoutMod.init;

import static com.MrpYA45.TheBoyScoutMod.util.InjectionUtil.Null;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.TileEntityWoodenBox;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MOD_ID)
public class ModTileEntities {

	public static final TileEntityType<?> WOODEN_BOX = Null();

	@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
			final TileEntityType<?>[] tile_entities = {
					TileEntityType.Builder.create(TileEntityWoodenBox::new).build(null).setRegistryName(Main.MOD_ID, "wooden_box")
			};
			
			event.getRegistry().registerAll(tile_entities);
		}
	}

}
