/*
 * This is the latest source code of Trample Everything.
 * Minecraft version: 1.17.x, mod version: 1.3.
 *
 * If you'd like access to the source code of previous Minecraft versions or previous mod versions, consider becoming a Github Sponsor or Patron.
 * You'll be added to a private repository which contains all versions' source of Trample Everything ever released, along with some other perks.
 *
 * Github Sponsor link: https://github.com/sponsors/ricksouth
 * Patreon link: https://patreon.com/ricksouth
 *
 * Becoming a Sponsor or Patron allows me to dedicate more time to the development of mods.
 * Thanks for looking at the source code! Hope it's of some use to your project. Happy modding!
 */

package com.natamus.trampleeverything.util;

import com.natamus.collective_fabric.functions.BlockFunctions;
import com.natamus.trampleeverything.config.ConfigHandler;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.BambooSaplingBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FungusBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.NetherSproutsBlock;
import net.minecraft.world.level.block.NetherWartBlock;
import net.minecraft.world.level.block.RootsBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.world.level.block.SeagrassBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.SugarCaneBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.WaterlilyBlock;

public class Util {
	public static void trampleCheck(Level world, BlockPos pos, Block block) {
		if (block instanceof FarmBlock) {
			pos = pos.above().immutable();
			block = world.getBlockState(pos).getBlock();
		}
		
		if (!isTrampleBlock(block)) {
			return;
		}
		
		if (ConfigHandler._enableTrampledBlockItems.getValue()) {
			BlockFunctions.dropBlock(world, pos);
		}
		else {
			world.destroyBlock(pos, false);
		}
	}
	
	private static boolean isTrampleBlock(Block block) {
		if (block instanceof SnowLayerBlock) {
			if (ConfigHandler.trampleSnow.getValue()) {
				return true;
			}
			return false;			
		}
		
		// Plant-type blocks
		if (block instanceof BambooSaplingBlock) {
			if (ConfigHandler.trampleBambooSaplings.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof CropBlock) {
			if (ConfigHandler.trampleCrops.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof DeadBushBlock) {
			if (ConfigHandler.trampleDeadBushes.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof DoublePlantBlock) {
			if (ConfigHandler.trampleDoublePlants.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof FlowerBlock) {
			if (ConfigHandler.trampleFlowers.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof FungusBlock) {
			if (ConfigHandler.trampleFungi.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof WaterlilyBlock) {
			if (ConfigHandler.trampleLilyPads.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof MushroomBlock) {
			if (ConfigHandler.trampleMushrooms.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof RootsBlock) {
			if (ConfigHandler.trampleNetherRoots.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof NetherSproutsBlock) {
			if (ConfigHandler.trampleNetherSprouts.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof NetherWartBlock) {
			if (ConfigHandler.trampleNetherWart.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof SaplingBlock) {
			if (ConfigHandler.trampleSaplings.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof SeagrassBlock) {
			if (ConfigHandler.trampleSeaGrass.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof SeaPickleBlock) {
			if (ConfigHandler.trampleSeaPickles.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof StemBlock || block instanceof AttachedStemBlock) {
			if (ConfigHandler.trampleStems.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof SugarCaneBlock) {
			if (ConfigHandler.trampleSugarCane.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof SweetBerryBushBlock) {
			if (ConfigHandler.trampleSweetBerryBushes.getValue()) {
				return true;
			}
			return false;
		}
		if (block instanceof TallGrassBlock) {
			if (ConfigHandler.trampleTallGrass.getValue()) {
				return true;
			}
			return false;
		}
		return false;
	}
}