/*
 * This is the latest source code of Biome Spawn Point.
 * Minecraft version: 1.19.2, mod version: 1.5.
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

package com.natamus.biomespawnpoint;

import com.natamus.biomespawnpoint.events.BiomeSpawnEvent;
import com.natamus.biomespawnpoint.util.Reference;
import com.natamus.biomespawnpoint.util.Util;
import com.natamus.collective_fabric.check.RegisterMod;
import com.natamus.collective_fabric.fabric.callbacks.CollectiveMinecraftServerEvents;
import net.fabricmc.api.ModInitializer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.ServerLevelData;

public class Main implements ModInitializer {
	@Override
	public void onInitialize() {
		registerEvents();
		
		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}
	
	private void registerEvents() {
		try {
			Util.loadSpawnBiomeConfig(null);
		} catch (Exception ex) {
			System.out.println("[Biome Spawn Point] Error: Unable to generate spawn biome list.");
			return;
		}

		CollectiveMinecraftServerEvents.WORLD_SET_SPAWN.register((ServerLevel serverLevel, ServerLevelData serverLevelData) -> {
			BiomeSpawnEvent.onWorldLoad(serverLevel, serverLevelData);
		});
	}
}
