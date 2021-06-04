package puppeteer.common.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import puppeteer.common.Puppeteer;

public class OpenScreenPacket {

    public static final Identifier SCREEN_PACKET = new Identifier(Puppeteer.MODID, "open_screen");
    //IDK HOW THIS WORK
    //WE ONLY NEED THIS TO OPEN SCREEN WITH COMMANDS
    public static void openScreenPacket() {
        ServerPlayNetworking.registerGlobalReceiver(SCREEN_PACKET, (server, player, handler, buf, responseSender) -> {

        });
    }
}
