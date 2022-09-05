/*
 * This is the latest source code of Collective.
 * Minecraft version: 1.19.2, mod version: 4.51.
 *
 * Please don't distribute without permission.
 * For all Minecraft modding projects, feel free to visit my profile page on CurseForge or Modrinth.
 *  CurseForge: https://curseforge.com/members/serilum/projects
 *  Modrinth: https://modrinth.com/user/serilum
 */

package com.natamus.collective_fabric.fabric.callbacks;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;

public class CollectiveSpawnEvents {
	private CollectiveSpawnEvents() { }
	 
    public static final Event<CollectiveSpawnEvents.Mob_Check_Spawn> MOB_CHECK_SPAWN = EventFactory.createArrayBacked(CollectiveSpawnEvents.Mob_Check_Spawn.class, callbacks -> (entity, world, spawnerPos, spawnReason) -> {
        for (CollectiveSpawnEvents.Mob_Check_Spawn callback : callbacks) {
        	if (!callback.onMobCheckSpawn(entity, world, spawnerPos, spawnReason)) {
        		return false;
        	}
        }
        
        return true;
    });
    
	@FunctionalInterface
	public interface Mob_Check_Spawn {
		 boolean onMobCheckSpawn(Mob entity, ServerLevel world, BlockPos spawnerPos, MobSpawnType spawnReason);
	}
}
