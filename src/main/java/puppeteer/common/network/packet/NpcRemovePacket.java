package puppeteer.common.network.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import puppeteer.client.screen.handler.NPCHandler;
import puppeteer.common.Puppeteer;
import puppeteer.common.entity.NPCEntity;

public class NpcRemovePacket {

    public static final Identifier ID = new Identifier(Puppeteer.MODID, "npc_remove");

    public static void send() {
        PacketByteBuf buf = PacketByteBufs.create();
        ClientPlayNetworking.send(ID, buf);
    }

    public static void handle(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler network, PacketByteBuf buf, PacketSender sender) {

        NPCEntity target = NPCHandler.getNPC();

        server.execute(() -> {

            if (target != null) {
                target.remove();
            }
        });
    }
}
