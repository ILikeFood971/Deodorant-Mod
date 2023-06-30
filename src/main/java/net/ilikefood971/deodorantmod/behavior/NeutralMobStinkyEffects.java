package net.ilikefood971.deodorantmod.behavior;

import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Box;

import java.util.HashSet;
import java.util.Set;

public class NeutralMobStinkyEffects {
    final Set<Angerable> madMobs = new HashSet<>();
    public void makeNeutralMobsMad(ServerPlayerEntity player) {
        Box box = player.getBoundingBox().expand(128);
        
        player.world.getEntitiesByClass(MobEntity.class, box, mob -> mob instanceof Angerable).forEach(mob -> {
            ((Angerable) mob).setAngryAt(player.getUuid());
            madMobs.add((Angerable) mob);
        });
    }
    public void clearEffects(ServerPlayerEntity player) {
        Set<Angerable> tempLoop = new HashSet<>(madMobs);
        
        for (Angerable mob : tempLoop) {
            if (mob.getAngryAt().equals(player.getUuid())) {
                mob.forgive(player);
                madMobs.remove(mob);
            }
        }
    }
}
