package com.MrpYA45.TheBoyScoutMod.init;

import static com.MrpYA45.TheBoyScoutMod.util.InjectionUtil.Null;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerBackpack;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerDiamondBox;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerGoldBox;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerIronBox;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerPaperBin;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerWoodenBox;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TheBoyScoutMod.MOD_ID)
public class ModContainers {

	public static final ContainerType<ContainerWoodenBox> WOODEN_BOX = Null();
	public static final ContainerType<ContainerIronBox> IRON_BOX = Null();
	public static final ContainerType<ContainerGoldBox> GOLD_BOX = Null();
	public static final ContainerType<ContainerDiamondBox> DIAMOND_BOX = Null();
	public static final ContainerType<ContainerEmeraldBox> EMERALD_BOX = Null();
	public static final ContainerType<ContainerPaperBin> PAPER_BIN = Null();
	public static final ContainerType<ContainerBackpack> BACKPACK = Null();

	@Mod.EventBusSubscriber(modid = TheBoyScoutMod.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerContainers(final RegistryEvent.Register<ContainerType<?>> event) {
			final ContainerType<?>[] containers = {
					new ContainerType<>(ContainerWoodenBox::new).setRegistryName(TheBoyScoutMod.MOD_ID, "wooden_box"),
					new ContainerType<>(ContainerIronBox::new).setRegistryName(TheBoyScoutMod.MOD_ID, "iron_box"),
					new ContainerType<>(ContainerGoldBox::new).setRegistryName(TheBoyScoutMod.MOD_ID, "gold_box"),
					new ContainerType<>(ContainerDiamondBox::new).setRegistryName(TheBoyScoutMod.MOD_ID, "diamond_box"),
					new ContainerType<>(ContainerEmeraldBox::new).setRegistryName(TheBoyScoutMod.MOD_ID, "emerald_box"),
					new ContainerType<>(ContainerPaperBin::new).setRegistryName(TheBoyScoutMod.MOD_ID, "paper_bin"),
					new ContainerType<>(ContainerBackpack::new).setRegistryName(TheBoyScoutMod.MOD_ID, "backpack")
			};
			
			event.getRegistry().registerAll(containers);
		}
	}

}
