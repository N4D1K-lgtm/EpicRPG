package com.kidannelson.epicrpg.events;


import com.kidannelson.epicrpg.EpicRPG;
import com.kidannelson.epicrpg.progression.PlayerProgression;
import com.kidannelson.epicrpg.progression.PlayerProgressionProvider;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EpicRPG.MOD_ID)
public class ModEvents {


    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerProgressionProvider.PLAYER_PROGESSION).isPresent()) {
                event.addCapability(new ResourceLocation(EpicRPG.MOD_ID, "properties"), new PlayerProgressionProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerProgressionProvider.PLAYER_PROGESSION).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerProgressionProvider.PLAYER_PROGESSION).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event){
        event.register(PlayerProgression.class);
    }
}
