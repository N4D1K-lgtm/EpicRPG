package com.kidannelson.epicrpg.item;

// Mod Imports
import com.kidannelson.epicrpg.EpicRPG;

// Minecraft Imports
import net.minecraft.world.item.Item;

// Forge Imports
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EpicRPG.MOD_ID);

    public static final RegistryObject<Item> SOUL_DAGGER = ITEMS.register("soul_dagger",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EPICRPG_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
