package net.ilikefood971.deodorantmod.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.ilikefood971.deodorantmod.DeodorantMod;
import net.ilikefood971.deodorantmod.behavior.NeutralMobStinkyEffects;
import net.ilikefood971.deodorantmod.behavior.PassiveMobStinkyEffects;
import net.ilikefood971.deodorantmod.util.StinkyData;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;


public class ServerTickHandler implements ServerTickEvents.StartWorldTick{
    private final NeutralMobStinkyEffects NEUTRAL_EFFECTS = new NeutralMobStinkyEffects();
    private final PassiveMobStinkyEffects PASSIVE_EFFECTS = new PassiveMobStinkyEffects();
    // True = day
    // False = night
    private long previousTime = 0;
    private long currentTime;
    
    @Override
    public void onStartTick(ServerWorld world) {
        if (!world.isClient) {
            checkForNewDay(world);
            applyEffectsIfStinky(world);
        }
    }
    private void checkForNewDay(ServerWorld world) {
        currentTime = world.getTimeOfDay() % 24000;
        if (currentTime == 0) {
            for (ServerPlayerEntity player : world.getPlayers()) {
                StinkyData.setStinky(player, true);
            }
        }
    }
    private void applyEffectsIfStinky(ServerWorld world) {
        for (ServerPlayerEntity player : world.getPlayers()) {
            if (!player.isCreative() && StinkyData.isStinky(player)) {
                NEUTRAL_EFFECTS.makeNeutralMobsMad(player);
                PASSIVE_EFFECTS.makePassiveMobsRunAway(player, 256);
            } else {
                NEUTRAL_EFFECTS.clearEffects(player);
                PASSIVE_EFFECTS.clearEffects(player);
            }
        }
    }
}
