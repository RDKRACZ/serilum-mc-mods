/*
 * This is the latest source code of Extended Creative Inventory.
 * Minecraft version: 1.18.2, mod version: 1.7.
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

package com.natamus.extendedcreativeinventory.util;

import java.lang.reflect.Field;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

public class Variables {
	public static Field item_group = ObfuscationReflectionHelper.findField(Item.class, "f_41377_"); // category
	public static CreativeModeTab EXTENDED = null;
}
