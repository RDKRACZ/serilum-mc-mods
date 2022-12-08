/*
 * This is the latest source code of Kelp Fertilizer.
 * Minecraft version: 1.19.3, mod version: 2.0.
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

package com.natamus.kelpfertilizer.dispenser;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.item.Items;

public class RecipeManager {
	public static void initDispenserBehavior() {
		try {
			DispenserBlock.registerBehavior(Items.KELP, new BehaviourKelpDispenser(Items.KELP));
		}
		catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("!!! Kelp Fertilizer: Something went wrong when adding the kelp behaviour to dispensers. Ignoring.");
			return;
		}
	}
}
