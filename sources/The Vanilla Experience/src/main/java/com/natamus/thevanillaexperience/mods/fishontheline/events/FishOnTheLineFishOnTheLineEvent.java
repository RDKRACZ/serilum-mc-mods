/*
 * This is the latest source code of The Vanilla Experience.
 * Minecraft version: 1.17.1, mod version: 1.4.
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

package com.natamus.thevanillaexperience.mods.fishontheline.events;

import java.util.HashMap;
import java.util.List;

import com.natamus.collective.data.GlobalVariables;
import com.natamus.thevanillaexperience.mods.fishontheline.config.FishOnTheLineConfigHandler;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.SynchedEntityData.DataItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class FishOnTheLineFishOnTheLineEvent {
	private static HashMap<String, Integer> sounddelay = new HashMap<String, Integer>();
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent e) {
		Player player = e.player;
		Level world = player.getCommandSenderWorld();
		if (world.isClientSide || !e.phase.equals(Phase.START)) {
			return;
		}
		
		FishingHook fbe = player.fishing;
		if (fbe == null) {
			return;
		}
		
		if (FishOnTheLineConfigHandler.GENERAL.mustHoldBellInOffhand.get()) {
			ItemStack offhandstack = player.getOffhandItem();
			if (!offhandstack.getItem().equals(Items.BELL)) {
				return;
			}
		}
		
		boolean fishontheline = false;
		int booleancount = 0;
		
		SynchedEntityData datamanager = fbe.getEntityData();
		List<DataItem<?>> entries = datamanager.getAll();
		for (DataItem<?> entry : entries) {
			String entryvalue = entry.getValue().toString();
			if (entryvalue.equalsIgnoreCase("true") || entryvalue.equalsIgnoreCase("false")) {
				if (booleancount >= 1) {
					if (entryvalue.equalsIgnoreCase("true")) {
						fishontheline = true;
					}
				}
				
				booleancount += 1;
			}
		}
		
		if (fishontheline) {
			int delay = 0;
			
			String playername = player.getName().getString();
			if (sounddelay.containsKey(playername)) {
				delay = sounddelay.get(playername);
			}
			
			if (delay == 0) {
				world.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.NEUTRAL, 0.5F, 0.4F / (GlobalVariables.random.nextFloat() * 0.4F + 0.8F));
				delay = 7;
			}
			else {
				delay -= 1;
			}
			
			sounddelay.put(playername, delay);
		}
	}
}
