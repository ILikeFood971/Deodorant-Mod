package net.ilikefood971.deodorantmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.ilikefood971.deodorantmod.DeodorantMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    
    public static final Item DEODORANT = registerItem("deodorant",
            new DeodorantItem(new FabricItemSettings()));
    
    
    
    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DeodorantMod.MOD_ID, name), item);
    }
    
    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.FUNCTIONAL, DEODORANT);
        
    }
    
    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    
    public static void registerModItems() {
        DeodorantMod.LOGGER.info("Registering Mod Items for " + DeodorantMod.MOD_ID);
        
        addItemsToItemGroup();
    }
    
    
    
    
    
}


