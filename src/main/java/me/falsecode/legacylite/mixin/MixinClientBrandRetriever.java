package me.falsecode.legacylite.mixin;

import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.obfuscate.DontObfuscate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ClientBrandRetriever.class)
public abstract class MixinClientBrandRetriever {

    /**
     * @author FalseCode
     * @reason Change Client Brand.
     */
    @DontObfuscate
    @Overwrite(remap = false)
    public static String getClientModName() {
        return "Legacy Lite";
    }
}
