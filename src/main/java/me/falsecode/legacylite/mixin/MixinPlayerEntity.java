package me.falsecode.legacylite.mixin;

import com.mojang.authlib.GameProfile;
import me.falsecode.legacylite.LegacyLite;
import me.falsecode.legacylite.util.Cape;
import me.falsecode.legacylite.util.LegacyIdentifier;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(PlayerEntity.class)
public abstract class MixinPlayerEntity {

    @Shadow
    public abstract GameProfile getGameProfile();

    @Inject(method = "isPartVisible", at = @At("HEAD"), cancellable = true)
    private void isPartVisible(PlayerModelPart modelPart, CallbackInfoReturnable<Boolean> cir) {
        if(modelPart != PlayerModelPart.CAPE) return;
        GameProfile profile = getGameProfile();
        if(profile == null) return;
        UUID uuid = profile.getId();
        if(LegacyLite.playerDataManager.hasCape(uuid)) {
            Cape cape = Cape.getCape(LegacyLite.playerDataManager.getCape(uuid));
            if(cape == null) return;
            LegacyIdentifier id = cape.getCape();
            if(id == null) return;
            cir.setReturnValue(true);
        }
    }
}
