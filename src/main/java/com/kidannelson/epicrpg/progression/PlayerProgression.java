package com.kidannelson.epicrpg.progression;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;

import java.util.ArrayList;
import java.util.List;

public class PlayerProgression {
    private int level = 0;
    private String playerClass = "Warrior";
    private List<String> unlockedSkills = new ArrayList<>();
    private List<String> equippedSkills = new ArrayList<>();

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

    public String getPlayerClass() {
        return this.playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public List<String> getUnlockedSkills() {
        return this.unlockedSkills;
    }

    public List<String> getEquippedSkills() {
        return this.equippedSkills;
    }

    public void unlockSkill(String skill) {
        this.unlockedSkills.add(skill);
    }
    public void equipSkill(String skill) {
        this.equippedSkills.add(skill);
    }
    public void copyFrom(PlayerProgression source) {
        this.level = source.level;
        this.playerClass = source.playerClass;
        this.unlockedSkills = source.unlockedSkills;
        this.equippedSkills = source.unlockedSkills;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("level", level );
//        nbt.putString("class", playerClass);
//        ListTag unlockedSkillsTag = new ListTag();
//        for (String skill : unlockedSkills) {
//            unlockedSkillsTag.add(StringTag.valueOf(skill));
//        }
//        nbt.put("unlockedSkills", unlockedSkillsTag);
//
//        ListTag equippedSkillsTag = new ListTag();
//        for (String skill : equippedSkills) {
//            equippedSkillsTag.add(StringTag.valueOf(skill));
//        }
//        nbt.put("equippedSkills", equippedSkillsTag);
    }

    public void loadNBTData(CompoundTag nbt) {
        level = nbt.getInt("level");
//      playerClass = nbt.getString("class");
//
//        unlockedSkills.clear();
//        ListTag unlockedSkillsTag = nbt.getList("unlockedSkills", Tag.TAG_STRING);
//        for (Tag tag : unlockedSkillsTag) {
//            unlockedSkills.add(tag.getAsString());
//        }
//        equippedSkills.clear();
//        ListTag equippedSkillsTag = nbt.getList("equippedSkills", Tag.TAG_STRING);
//        for (Tag tag : equippedSkillsTag) {
//            equippedSkills.add(tag.getAsString());
//        }
    }
}
