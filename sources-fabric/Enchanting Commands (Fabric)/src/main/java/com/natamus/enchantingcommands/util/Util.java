/*
 * This is the latest source code of Enchanting Commands.
 * Minecraft version: 1.19.1, mod version: 2.3.
 *
 * If you'd like access to the source code of previous Minecraft versions or previous mod versions, consider becoming a Github Sponsor or Patron.
 * You'll be added to a private repository which contains all versions' source of Enchanting Commands ever released, along with some other perks.
 *
 * Github Sponsor link: https://github.com/sponsors/ricksouth
 * Patreon link: https://patreon.com/ricksouth
 *
 * Becoming a Sponsor or Patron allows me to dedicate more time to the development of mods.
 * Thanks for looking at the source code! Hope it's of some use to your project. Happy modding!
 */

package com.natamus.enchantingcommands.util;

import net.minecraft.core.Registry;

import java.util.*;

public class Util {
	final static Map<String, Integer> enchantmentMap = new HashMap<String, Integer>() {{
		for (int x = 0; x < Registry.ENCHANTMENT.size(); x++) {
			String rawname = Registry.ENCHANTMENT.byId(x).getDescriptionId().replace("enchantment.", "").replace("minecraft.", "");
			String[] rnspl = rawname.split("\\.");
			String enchantmentname = rnspl[rnspl.length-1];
			put(enchantmentname, x);
		}
	}};

	public static List<String> enchantments() {
		List<String> enchantments = new ArrayList<String>(enchantmentMap.keySet());
		Collections.sort(enchantments);
		return enchantments;
	}

	public static Integer getEnchantmentID(String enchantment) {
		return enchantmentMap.get(enchantment);
	}
}
