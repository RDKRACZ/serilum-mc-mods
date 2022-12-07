/*
 * This is the latest source code of Pet Names.
 * Minecraft version: 1.19.3, mod version: 2.4.
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

package com.natamus.petnames;

import com.natamus.collective_fabric.check.RegisterMod;
import com.natamus.collective_fabric.fabric.callbacks.CollectiveAnimalEvents;
import com.natamus.petnames.config.ConfigHandler;
import com.natamus.collective_fabric.config.DuskConfig;
import com.natamus.petnames.events.EntityEvent;
import com.natamus.petnames.util.Reference;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Animal;

public class Main implements ModInitializer {
	@Override
	public void onInitialize() { 
		DuskConfig.init(Reference.MOD_ID, ConfigHandler.class);

		registerEvents();
		
		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}
	
	private void registerEvents() {
		CollectiveAnimalEvents.PRE_BABY_SPAWN.register((ServerLevel world, Animal parentA, Animal parentB, AgeableMob offspring) -> {
			EntityEvent.onBaby(world, parentA, parentB, offspring);
			return true;
		});
	}
}
