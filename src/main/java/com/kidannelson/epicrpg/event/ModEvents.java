package com.kidannelson.epicrpg.event;


import com.kidannelson.epicrpg.EpicRPG;
import com.kidannelson.epicrpg.networking.ModMessages;
import com.kidannelson.epicrpg.networking.packet.ProgressionDataSyncS2CPacket;
import com.kidannelson.epicrpg.progression.PlayerProgression;
import com.kidannelson.epicrpg.progression.PlayerProgressionProvider;

import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.item.Items;
import net.minecraft.network.chat.TextComponent;

import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
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
