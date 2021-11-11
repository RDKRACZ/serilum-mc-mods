/*
 * This is the latest source code of Automatic Doors.
 * Minecraft version: 1.17.x, mod version: 1.9.
 *
 * If you'd like access to the source code of previous Minecraft versions or previous mod versions, consider becoming a Github Sponsor or Patron.
 * You'll be added to a private repository which contains all versions' source of Automatic Doors ever released, along with some other perks.
 *
 * Github Sponsor link: https://github.com/sponsors/ricksouth
 * Patreon link: https://patreon.com/ricksouth
 *
 * Becoming a Sponsor or Patron allows me to dedicate more time to the development of mods.
 * Thanks for looking at the source code! Hope it's of some use to your project. Happy modding!
 */

package com.natamus.automaticdoors.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.natamus.automaticdoors.config.ConfigHandler;
import com.natamus.automaticdoors.util.Util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;

public class DoorEvent {	
	public static List<BlockPos> toclosedoors = new ArrayList<BlockPos>();
	public static List<BlockPos> newclosedoors = new ArrayList<BlockPos>();
	
	public static void onPlayerTick(ServerLevel world, ServerPlayer player) {
		if (player.isSpectator()) {
			return;
		}
				
		if (newclosedoors.size() > 0) {
			toclosedoors.addAll(newclosedoors);
			newclosedoors = new ArrayList<BlockPos>();
		}
		
		BlockPos ppos = player.blockPosition().above().immutable();
		if (toclosedoors.size() > 0) {
			List<BlockPos> closetoremove = new ArrayList<BlockPos>();
			
			for (BlockPos bp : toclosedoors) {
				if (bp == null) {
					closetoremove.add(bp);
					continue;
				}
				BlockState state = world.getBlockState(bp);
				Block block = state.getBlock();
				if (!Util.isDoor(block)) {
					closetoremove.add(bp);
					continue;
				}
								
				if (!ppos.closerThan(bp, 3) || (ConfigHandler.preventOpeningOnSneak.getValue() && player.isShiftKeyDown())) {
					Iterator<BlockPos> it0 = BlockPos.betweenClosed(bp.getX()-1, bp.getY(), bp.getZ()-1, bp.getX()+1, bp.getY(), bp.getZ()+1).iterator();
					while (it0.hasNext()) {
						BlockPos aroundpos = it0.next();
						BlockState aroundstate = world.getBlockState(aroundpos);
						Block aroundblock = aroundstate.getBlock();
						if (Util.isDoor(aroundblock)) {
							((DoorBlock)block).setOpen(player, world, aroundstate, aroundpos, false); // toggleDoor
						}
					}
					
					closetoremove.add(bp);
				}
			}
			
			if (closetoremove.size() > 0) {
				for (BlockPos tr : closetoremove) {
					toclosedoors.remove(tr);
				}
			}
		}
		
		if (player.isShiftKeyDown()) {
			if (ConfigHandler.preventOpeningOnSneak.getValue()) {
				return;
			}
		}
		
		Iterator<BlockPos> it1 = BlockPos.betweenClosedStream(ppos.getX()-1, ppos.getY(), ppos.getZ()-1, ppos.getX()+1, ppos.getY(), ppos.getZ()+1).iterator();
		while (it1.hasNext()) {
			BlockPos np = it1.next();
			BlockState state = world.getBlockState(np);
			Block block = state.getBlock();
			if (Util.isDoor(block)) {
				if (toclosedoors.contains(np) || newclosedoors.contains(np)) {
					continue;
				}
				
				((DoorBlock)block).setOpen(player, world, state, np, true); // toggleDoor
				Util.delayDoorClose(np.immutable());
			}
		}
	}
}