package com.kidannelson.epicrpg.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.lwjgl.system.CallbackI;

public class ModCreativeModeTab {
    public static final CreativeModeTab EPICRPG_TAB = new CreativeModeTab("epicrpgtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SOUL_DAGGER.get());
        }
    };
}
