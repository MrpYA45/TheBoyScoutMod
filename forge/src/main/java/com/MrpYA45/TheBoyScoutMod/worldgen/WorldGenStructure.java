//package com.MrpYA45.TheBoyScoutMod.worldgen;
//
//import java.util.Random;
//
//import com.MrpYA45.TheBoyScoutMod.util.IStructure;
//import com.MrpYA45.TheBoyScoutMod.util.Reference;
//
//import net.minecraft.block.BlockState;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraft.world.WorldServer;
//import net.minecraft.world.gen.feature.WorldGenerator;
//import net.minecraft.world.gen.structure.template.Template;
//import net.minecraft.world.gen.structure.template.TemplateManager;
//
//public class WorldGenStructure extends WorldGenerator implements IStructure {
//	
//	public String structureName;
//	
//	public WorldGenStructure(String name) {
//		this.structureName = name;
//	}
//
//	@Override
//	public boolean generate(World worldIn, Random rand, BlockPos position) {
//		this.generateStructure(worldIn, position);
//		return true;
//	}
//	
//	public void generateStructure(World world, BlockPos pos) {
//		WorldServer worldServer = (WorldServer) world;
//		MinecraftServer mcServer = world.getMinecraftServer();
//		TemplateManager manager = worldServer.getStructureTemplateManager();
//		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, structureName);
//		Template template = manager.get(mcServer, location);
//		
//		if(template != null && WorldGenCustomStructures.canSpawnHere(template, worldServer, pos)) {
//			BlockState state = world.getBlockState(pos);
//			world.notifyBlockUpdate(pos, state, state, 3);
//			if(structureName == "palm_tree") {
//				template.addBlocksToWorldChunk(world, pos.up(), settings);
//			} else {
//				template.addBlocksToWorldChunk(world, pos, settings);
//			}
//		}
//	}
//	
//}
