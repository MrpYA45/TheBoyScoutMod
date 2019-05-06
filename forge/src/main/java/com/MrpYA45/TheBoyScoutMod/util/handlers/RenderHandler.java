package com.MrpYA45.TheBoyScoutMod.util.handlers;

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
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderDiamondGolem;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderEmeraldGolem;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderFish;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderGoldGolem;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderGolem;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderIronGolem;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderPenguin;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderSquirrel;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderStoneGolem;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT)
public class RenderHandler {
	
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySquirrel.class, new IRenderFactory<EntitySquirrel>() {

			@Override
			public Render<? super EntitySquirrel> createRenderFor(RenderManager manager) {
				return new RenderSquirrel(manager); 
			}
		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class, new IRenderFactory<EntityPenguin>() {
//
//			@Override
//			public Render<? super EntityPenguin> createRenderFor(RenderManager manager) {
//				return new RenderPenguin(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityFish.class, new IRenderFactory<EntityFish>() {
//
//			@Override
//			public Render<? super EntityFish> createRenderFor(RenderManager manager) {
//				return new RenderFish(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityGolem.class, new IRenderFactory<EntityGolem>() {
//
//			@Override
//			public Render<? super EntityGolem> createRenderFor(RenderManager manager) {
//				return new RenderGolem(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityStoneGolem.class, new IRenderFactory<EntityStoneGolem>() {
//
//			@Override
//			public Render<? super EntityStoneGolem> createRenderFor(RenderManager manager) {
//				return new RenderStoneGolem(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityIronGolem.class, new IRenderFactory<EntityIronGolem>() {
//
//			@Override
//			public Render<? super EntityIronGolem> createRenderFor(RenderManager manager) {
//				return new RenderIronGolem(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityGoldGolem.class, new IRenderFactory<EntityGoldGolem>() {
//
//			@Override
//			public Render<? super EntityGoldGolem> createRenderFor(RenderManager manager) {
//				return new RenderGoldGolem(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondGolem.class, new IRenderFactory<EntityDiamondGolem>() {
//
//			@Override
//			public Render<? super EntityDiamondGolem> createRenderFor(RenderManager manager) {
//				return new RenderDiamondGolem(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldGolem.class, new IRenderFactory<EntityEmeraldGolem>() {
//
//			@Override
//			public Render<? super EntityEmeraldGolem> createRenderFor(RenderManager manager) {
//				return new RenderEmeraldGolem(manager); 
//			}
//		});
	}
}
