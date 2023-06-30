package net.ilikefood971.deodorantmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.ilikefood971.deodorantmod.event.ServerTickHandler;
import net.ilikefood971.deodorantmod.event.SleepHandler;
import net.ilikefood971.deodorantmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeodorantMod implements ModInitializer {
    public static final String MOD_ID = "deodorantmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    @Override
    public void onInitialize() {
        
        ModItems.registerModItems();
        ServerTickEvents.START_WORLD_TICK.register(new ServerTickHandler());
        EntitySleepEvents.STOP_SLEEPING.register(new SleepHandler());

    }
    
    
    
}