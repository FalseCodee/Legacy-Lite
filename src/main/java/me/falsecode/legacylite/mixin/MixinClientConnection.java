package me.falsecode.legacylite.mixin;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ClientConnection.class)
public class MixinClientConnection {
    @Inject(method = "handlePacket", at = @At(value = "HEAD"), cancellable = true)
    private static  <T extends PacketListener> void onPacket(Packet<T> packet, PacketListener listener, CallbackInfo ci){
        if(!(packet instanceof GameMessageS2CPacket p)) return;
        String message = concatArray(p.content().withoutStyle(), "");
        if(message.split(" ")[0].toUpperCase().contains("[AD]")) {
            ci.cancel();
        }
    }

    @Unique
    private static String concatArray(List<Text> array, String concat) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.size(); i++) {
            sb.append(array.get(i).getString());
            if(i < array.size() - 1) {
                sb.append(concat);
            }
        }

        return sb.toString();
    }
}
