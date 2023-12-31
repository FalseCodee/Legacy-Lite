package me.falsecode.legacylite.util;

import net.minecraft.util.Identifier;

public class LegacyIdentifier extends Identifier {
    private final int width;
    private final int height;
    public LegacyIdentifier(String path, int width, int height) {
        super("falsify", path);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
