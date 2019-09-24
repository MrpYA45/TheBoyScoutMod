package com.MrpYA45.TheBoyScoutMod.init;

import static com.MrpYA45.TheBoyScoutMod.util.InjectionUtil.Null;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.ContainerWoodenBox;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class ModContainers {

	public static final ContainerType<ContainerWoodenBox> WOODEN_BOX = Null();

	@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
			final ContainerType<?>[] containers = {
					new ContainerType<>(ContainerWoodenBox::new).setRegistryName(Main.MOD_ID, "wooden_box")
			};
			
			event.getRegistry().registerAll(containers);
		}
	}

}
