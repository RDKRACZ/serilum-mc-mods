/*
 * This is the latest source code of Collective.
 * Minecraft version: 1.19.2, mod version: 5.13.
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

package com.natamus.collective_fabric.fabric.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.natamus.collective_fabric.fabric.callbacks.CollectiveExplosionEvents;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

@Mixin(value = Explosion.class, priority = 1001)
public class ExplosionMixin {
	@Final @Shadow private Level level;
	@Final @Shadow private Entity source;
	
	@Inject(method = "explode()V", at = @At(value = "TAIL"))
	public void Explosion_explode(CallbackInfo ci) {
		Explosion explosion = (Explosion)(Object)this;
		CollectiveExplosionEvents.EXPLOSION_DETONATE.invoker().onDetonate(level, source, explosion);
	}
}