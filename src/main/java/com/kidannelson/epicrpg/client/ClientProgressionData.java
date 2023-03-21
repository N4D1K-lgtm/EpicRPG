package com.kidannelson.epicrpg.client;

public class ClientProgressionData {
    
    private static int playerLevel;
    
    public static void set(int level) {
        ClientProgressionData.playerLevel = playerLevel;
    }
    
    public static int getPlayerplayerLevel() {
        return playerLevel;
    }
}
