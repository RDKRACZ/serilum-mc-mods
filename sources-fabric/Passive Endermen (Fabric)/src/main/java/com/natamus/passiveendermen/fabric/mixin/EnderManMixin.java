/*
 * This is the latest source code of Passive Endermen.
 * Minecraft version: 1.19.x, mod version: 2.2.
 *
 * If you'd like access to the source code of previous Minecraft versions or previous mod versions, consider becoming a Github Sponsor or Patron.
 * You'll be added to a private repository which contains all versions' source of Passive Endermen ever released, along with some other perks.
 *
 * Github Sponsor link: https://github.com/sponsors/ricksouth
 * Patreon link: https://patreon.com/ricksouth
 *
 * Becoming a Sponsor or Patron allows me to dedicate more time to the development of mods.
 * Thanks for looking at the source code! Hope it's of some use to your project. Happy modding!
 */

package com.natamus.passiveendermen.fabric.mixin;

import com.natamus.collective_fabric.functions.ConfigFunctions;
import com.natamus.passiveendermen.util.Reference;
import net.minecraft.world.entity.monster.EnderMan;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EnderMan.class, priority = 1001)
public class EnderManMixin {
    @Inject(method = "teleport(DDD)Z", at = @At(value = "HEAD"), cancellable = true)
    private void teleport(double p_32544_, double p_32545_, double p_32546_, CallbackInfoReturnable<Boolean> cir) {
        if (ConfigFunctions.getDictValues(Reference.MOD_ID).get("preventEndermenFromTeleporting").equals("true")) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "registerGoals()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ai/goal/GoalSelector;addGoal(ILnet/minecraft/world/entity/ai/goal/Goal;)V", ordinal = 8), cancellable = true)
    protected void registerGoals(CallbackInfo ci) {
        if (ConfigFunctions.getDictValues(Reference.MOD_ID).get("preventEndermenFromAttacking").equals("true")) {
            ci.cancel();
        }
    }
}