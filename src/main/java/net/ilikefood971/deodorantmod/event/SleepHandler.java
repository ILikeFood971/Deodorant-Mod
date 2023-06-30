package net.ilikefood971.deodorantmod.event;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.ilikefood971.deodorantmod.DeodorantMod;
import net.ilikefood971.deodorantmod.util.StinkyData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;

public class SleepHandler implements EntitySleepEvents.StopSleeping {
    
    @Override
    public void onStopSleeping(LivingEntity entity, BlockPos sleepingPos) {
        DeodorantMod.LOGGER.info("Stopped Sleeping");
        StinkyData.setStinky((PlayerEntity) entity, true);
    }
}
