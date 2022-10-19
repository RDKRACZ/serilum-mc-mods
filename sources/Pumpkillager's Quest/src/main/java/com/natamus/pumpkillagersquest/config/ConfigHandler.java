/*
 * This is the latest source code of Pumpkillager's Quest.
 * Minecraft version: 1.19.2, mod version: 1.2.
 *
 * Please don't distribute without permission.
 * For all Minecraft modding projects, feel free to visit my profile page on CurseForge or Modrinth.
 *  CurseForge: https://curseforge.com/members/serilum/projects
 *  Modrinth: https://modrinth.com/user/serilum
 *  Overview: https://serilum.com/
 *
 * If you are feeling generous and would like to support the development of the mods, you can!
 *  https://ricksouth.com/donate contains all the information. <3
 *
 * Thanks for looking at the source code! Hope it's of some use to your project. Happy modding!
 */

package com.natamus.pumpkillagersquest.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final General GENERAL = new General(BUILDER);
	public static final ForgeConfigSpec spec = BUILDER.build();

	public static class General {
		//public final ForgeConfigSpec.ConfigValue<Boolean> alwaysDropShells;
		//public final ForgeConfigSpec.ConfigValue<Integer> shulkerDropAmount;

		public General(ForgeConfigSpec.Builder builder) {
			builder.push("General");
			/*alwaysDropShells = builder
					.comment("Ignore the drop chance (default 50%) that a Shulker will drop their shell and instead makes them always drop it.")
					.define("alwaysDropShells", false);*/
			/*shulkerDropAmount = builder
					.comment("Sets the amount of shells Shulkers drop.")
					.defineInRange("shulkerDropAmount", 2, 1, 64);*/
			
			builder.pop();
		}
	}
}