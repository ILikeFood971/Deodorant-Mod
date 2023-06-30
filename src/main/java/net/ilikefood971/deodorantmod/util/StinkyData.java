package net.ilikefood971.deodorantmod.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class StinkyData {
    public static boolean setStinky(PlayerEntity player, boolean isStinky) {
        IEntityDataSaver player1 = ((IEntityDataSaver) player);
        NbtCompound nbt = player1.getPersistentData();
        if (!player.isCreative() && !nbt.getBoolean("stinky") == isStinky) {
            nbt.putBoolean("stinky", isStinky);
            if (isStinky) {
                player.sendMessage(Text.of("You stink. I would try to smell better before you encounter anything hostile..."));
            } else {
                player.sendMessage(Text.of("Good job! You applied deodorant!"));
            }
            return true;
        } else return false;
    }
    public static boolean isStinky(PlayerEntity player) {
        IEntityDataSaver player1 = ((IEntityDataSaver) player);
        NbtCompound nbt = player1.getPersistentData();
        
        return nbt.getBoolean("stinky");
        
    }
}
