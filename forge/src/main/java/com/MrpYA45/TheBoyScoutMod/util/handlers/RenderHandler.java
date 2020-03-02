package com.MrpYA45.TheBoyScoutMod.util.handlers;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.EntityFish;
import com.MrpYA45.TheBoyScoutMod.entity.EntityPenguin;
import com.MrpYA45.TheBoyScoutMod.entity.EntitySquirrel;
import com.MrpYA45.TheBoyScoutMod.entity.golems.EntityGolem;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderFish;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderGolem;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderPenguin;
import com.MrpYA45.TheBoyScoutMod.entity.render.RenderSquirrel;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = TheBoyScoutMod.MOD_ID, value = Dist.CLIENT)
public class RenderHandler {

	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntitySquirrel.class, new IRenderFactory<EntitySquirrel>() {

			@Override
			public EntityRenderer<? super EntitySquirrel> createRenderFor(EntityRendererManager manager) {
				return new RenderSquirrel(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class, new IRenderFactory<EntityPenguin>() {

			@Override
			public EntityRenderer<? super EntityPenguin> createRenderFor(EntityRendererManager manager) {
				return new RenderPenguin(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityFish.class, new IRenderFactory<EntityFish>() {

			@Override
			public EntityRenderer<? super EntityFish> createRenderFor(EntityRendererManager manager) {
				return new RenderFish(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityGolem.class, new IRenderFactory<EntityGolem>() {

			@Override
			public EntityRenderer<? super EntityGolem> createRenderFor(EntityRendererManager manager) {
				return new RenderGolem(manager);
			}
		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityStoneGolem.class, new IRenderFactory<EntityStoneGolem>() {
//
//			@Override
//			public EntityRenderer<? super EntityStoneGolem> createRenderFor(EntityRendererManager manager) {
//				return new RenderStoneGolem(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityIronGolem.class, new IRenderFactory<EntityIronGolem>() {
//
//			@Override
//			public EntityRenderer<? super EntityIronGolem> createRenderFor(EntityRendererManager manager) {
//				return new RenderIronGolem(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityGoldGolem.class, new IRenderFactory<EntityGoldGolem>() {
//
//			@Override
//			public EntityRenderer<? super EntityGoldGolem> createRenderFor(EntityRendererManager manager) {
//				return new RenderGoldGolem(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityDiamondGolem.class, new IRenderFactory<EntityDiamondGolem>() {
//
//			@Override
//			public EntityRenderer<? super EntityDiamondGolem> createRenderFor(EntityRendererManager manager) {
//				return new RenderDiamondGolem(manager); 
//			}
//		});
//		RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldGolem.class, new IRenderFactory<EntityEmeraldGolem>() {
//
//			@Override
//			public EntityRenderer<? super EntityEmeraldGolem> createRenderFor(EntityRendererManager manager) {
//				return new RenderEmeraldGolem(manager); 
//			}
//		});
	}
}
