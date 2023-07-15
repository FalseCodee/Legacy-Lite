package me.falsecode.legacylite.mixin;

import me.falsecode.legacylite.LegacyLite;
import me.falsecode.legacylite.util.Cape;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    @Inject(method = "<init>(Lnet/minecraft/client/RunArgs;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/SplashOverlay;init(Lnet/minecraft/client/MinecraftClient;)V", shift = At.Shift.AFTER))
    public void registerTextures(RunArgs args, CallbackInfo ci) {
        LegacyLite.init();
        LegacyLite.textureCacheManager.registerTextures();
        Cape.addCapes();
    }
}
