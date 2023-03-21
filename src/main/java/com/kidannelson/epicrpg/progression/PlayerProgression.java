package com.kidannelson.epicrpg.progression;

import net.minecraft.nbt.CompoundTag;

import java.util.List;

public class PlayerProgression {
    private int level;
    private String playerClass;
    private int[] skills;

    public int getLevel() {
        return this.level;
    }
    public void addLevel(int levelsToAdd) {
        this.level += levelsToAdd;
    }

    public void subLevel(int levelsToSub) {
        this.level -= levelsToSub;
    }

    public void setLevel(int levelToSet) {
        this.level = levelToSet;
    }

    public void copyFrom(PlayerProgression source) {
        this.level = source.level;
        this.playerClass = source.playerClass;
        this.skills = source.skills;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("level", level );
        nbt.putString("class", playerClass);
        nbt.putIntArray("skills", skills);
    }

    public void loadNBTData(CompoundTag nbt) {
        level = nbt.getInt("level");
        playerClass = nbt.getString("class");
        skills = nbt.getIntArray("skills");
    }
}
