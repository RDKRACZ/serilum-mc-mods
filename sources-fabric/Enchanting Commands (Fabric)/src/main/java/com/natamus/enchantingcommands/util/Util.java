/*
 * This is the latest source code of Enchanting Commands.
 * Minecraft version: 1.19.2, mod version: 2.5.
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

package com.natamus.enchantingcommands.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<String> getEnchantmentKeys() {
        List<String> output = new ArrayList<String>();
        for (ResourceLocation rl : Registry.ENCHANTMENT.keySet()) {
            output.add(rl.toString().replaceAll("minecraft:", ""));
        }
        return output;
    }
}
