package com.MrpYA45.TheBoyScoutMod.util;

import java.nio.file.Path;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;

//package com.MrpYA45.TheBoyScoutMod.util;
//
//import net.minecraftforge.common.config.Config;
//import net.minecraftforge.common.config.Config.Comment;
//import net.minecraftforge.common.config.Config.Name;
//import net.minecraftforge.common.config.Config.RangeInt;
//import net.minecraftforge.common.config.Config.RequiresMcRestart;
//import net.minecraftforge.common.config.Config.Type;
//

public class TBSMConfig {

	public static Server SERVER;
	public static ForgeConfigSpec SERVER_SPEC;

	static {
		Pair<Server, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(Server::new);
		SERVER_SPEC = commonPair.getRight();
		SERVER = commonPair.getLeft();
	}
	
    public static void loadConfig(ForgeConfigSpec spec, Path path) {

        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }

	public static class Server {
		
		public static ForgeConfigSpec.IntValue bluepowderfrecuency;
		
		private Server(ForgeConfigSpec.Builder builder) {
			builder.push("General");
			bluepowderfrecuency = builder.comment("").translation("").defineInRange("blue_powder_frecuency", 50, 0, 100);
			builder.pop();
		}

	}
}

//@Config(modid = Reference.MOD_ID, name = "theboyscoutmod", type = Type.INSTANCE)
//public class TBSMConfig {
//	
//	@Name("Blue Powder Frecuency")
//	@Comment("This value set the ammount of Blue Powder veins in world.")
//	@RangeInt(min = 0, max = 100)
//	public static int blue_powder_frecuency = 50;
//	
//	public static FlowersGen Flowers = new FlowersGen();
//	
//	public static class FlowersGen {
//		@Name("Blue Flower Frecuency")
//		@Comment("This value set the ammount of Blue Flowers which will be generated in world.")
//		@RangeInt(min = 0, max = 100)
//		@RequiresMcRestart
//		public int blue_flower_frecuency = 5;
//		
//		@Name("Pink Flower Frecuency")
//		@Comment("This value set the ammount of Pink Flowers which will be generated in world.")
//		@RangeInt(min = 0, max = 100)
//		@RequiresMcRestart
//		public int pink_flower_frecuency = 5;
//		
//		@Name("Orange Flower Frecuency")
//		@Comment("This value set the ammount of Orange Flowers which will be generated in world.")
//		@RangeInt(min = 0, max = 100)
//		@RequiresMcRestart
//		public int orange_flower_frecuency = 5;
//		
//		@Name("Weeds Frecuency")
//		@Comment("This value set the ammount of Weeds Flowers which will be generated in world.")
//		@RangeInt(min = 0, max = 100)
//		@RequiresMcRestart
//		public int weeds_frecuency = 5;
//		
//	}
//}
