/*
 * This is the latest source code of Replanting Crops.
 * Minecraft version: 1.19.3, mod version: 4.1.
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

package com.natamus.replantingcrops.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ConfigHandler {
	private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final General GENERAL = new General(BUILDER);
	public static final ForgeConfigSpec spec = BUILDER.build();

	public static class General {
		public final ForgeConfigSpec.ConfigValue<Boolean> mustHoldHoeForReplanting;

		public General(ForgeConfigSpec.Builder builder) {
			builder.push("General");
			mustHoldHoeForReplanting = builder
					.comment("If enabled, players must hold a hoe in their hand to automatically replant the crop.")
					.define("mustHoldHoeForReplanting", true);
			
			builder.pop();
		}
	}
}
