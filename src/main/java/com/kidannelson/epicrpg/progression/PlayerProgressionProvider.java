package com.kidannelson.epicrpg.progression;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerProgressionProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<PlayerProgression> PLAYER_PROGESSION =
            CapabilityManager.get(new CapabilityToken<PlayerProgression>() {});

    private PlayerProgression progression = null;
    private final LazyOptional<PlayerProgression> optional = LazyOptional.of(this::createPlayerProgression);

    private PlayerProgression createPlayerProgression() {
        if(this.progression == null) {
            this.progression = new PlayerProgression();
        }

        return this.progression;

    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_PROGESSION) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerProgression().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerProgression().loadNBTData(nbt);
    }
}
