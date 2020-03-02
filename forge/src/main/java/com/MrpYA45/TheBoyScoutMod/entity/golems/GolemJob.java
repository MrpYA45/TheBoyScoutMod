package com.MrpYA45.TheBoyScoutMod.entity.golems;

import java.util.Arrays;
import java.util.Comparator;

public enum GolemJob {
	UNEMPLOYED(0, "unemployed"),
	FARMER(1, "farmer"),
	LUMBERJACK(2, "lumberjack");

	private static final GolemJob[] VALUES = Arrays.stream(values()).sorted(Comparator.comparingInt(GolemJob::getId)).toArray((p_199795_0_) -> {
		return new GolemJob[p_199795_0_];
	});
	private final int id;
	private final String name;
	private GolemJob(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

   public static GolemJob byId(int id) {
	      if (id < 0 || id >= VALUES.length) {
	         id = 0;
	      }

	      return VALUES[id];
	   }
}