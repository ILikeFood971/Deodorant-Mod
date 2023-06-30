package net.ilikefood971.deodorantmod.behavior;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Box;

import java.util.HashSet;
import java.util.Set;

public class PassiveMobStinkyEffects {
    final Set<MobEntity> scaredMobs = new HashSet<>();
    
    public void makePassiveMobsRunAway(ServerPlayerEntity player, double distance) {
        Box box = player.getBoundingBox().expand(distance);
        for (MobEntity mob : player.world.getEntitiesByClass(MobEntity.class, box, LivingEntity::isAlive)) {
            if (mob.canSee(player)) {
                mob.setAttacker(player);
                mob.getNavigation().setSpeed(1.5);
                scaredMobs.add(mob);
            }
        }
    }
    public void clearEffects(ServerPlayerEntity player) {
        for (MobEntity mob : scaredMobs) {
            if (mob.getAttacker() == player) mob.setAttacker(null);
        }
    }
}
