package net.ilikefood971.deodorantmod.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;

public class StinkyData {
    public static void setStinky(PlayerEntity player, boolean isStinky) {
        IEntityDataSaver player1 = ((IEntityDataSaver) player);
        NbtCompound nbt = player1.getPersistentData();
        if (!player.isCreative() && !nbt.getBoolean("stinky") == isStinky) {
            nbt.putBoolean("stinky", isStinky);
            if (isStinky) {
                player.sendMessage(Text.translatable("util.stinkydata.stinky"));
            } else {
                player.sendMessage(Text.translatable("util.stinkydata.clean"));
            }
        }
    }
    public static boolean isStinky(PlayerEntity player) {
        IEntityDataSaver player1 = ((IEntityDataSaver) player);
        NbtCompound nbt = player1.getPersistentData();
        
        return nbt.getBoolean("stinky");
        
    }
}
