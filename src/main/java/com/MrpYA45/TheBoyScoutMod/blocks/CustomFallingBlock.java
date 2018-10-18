package com.MrpYA45.TheBoyScoutMod.blocks;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomFallingBlock extends BlockFalling implements IHasModel {
	public CustomFallingBlock(String name, Material material) {
		super(material.SAND);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTheBoyScoutMod);
		setSoundType(SoundType.SAND);
		setHardness(0.6F);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
    @SideOnly(Side.CLIENT)
    public int getDustColor(IBlockState state)
    {
        return 4137;
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");		
	}
	
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ModItems.BLUE_POWDER;
    }
    
    public int quantityDropped(Random random)
    {
        return 1 + random.nextInt(2);
    }
}
