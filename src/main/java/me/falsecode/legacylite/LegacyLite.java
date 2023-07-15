package me.falsecode.legacylite;

import me.falsecode.legacylite.util.PlayerDataManager;
import me.falsecode.legacylite.util.TextureCacheManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Session;

import java.io.File;

public class LegacyLite {
    public static final MinecraftClient mc = MinecraftClient.getInstance();
    public static TextureCacheManager textureCacheManager;
    public static PlayerDataManager playerDataManager;
    public static File clientDir;

    public static void init() {
        String clientDirPath = mc.runDirectory.getAbsolutePath()+"\\legacy_client";
        clientDir = new File(clientDirPath);
        clientDir.mkdirs();
        LegacyLite.textureCacheManager = new TextureCacheManager();
        LegacyLite.playerDataManager = new PlayerDataManager();
    }
}
