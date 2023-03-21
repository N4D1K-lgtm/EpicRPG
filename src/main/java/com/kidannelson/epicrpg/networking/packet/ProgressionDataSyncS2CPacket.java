package com.kidannelson.epicrpg.networking.packet;

import com.kidannelson.epicrpg.client.ClientProgressionData;
import com.kidannelson.epicrpg.progression.PlayerProgressionProvider;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;
public class ProgressionDataSyncS2CPacket {
    private final int level;

    public ProgressionDataSyncS2CPacket(int level) {
        this.level = level;
    }

    public ProgressionDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.level = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(level);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            ClientProgressionData.set(level);
        });
        return true;
    }
}