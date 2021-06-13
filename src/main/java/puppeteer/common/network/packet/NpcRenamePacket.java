package puppeteer.common.network.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import puppeteer.client.screen.handler.NPCHandler;
import puppeteer.common.Puppeteer;
import puppeteer.common.entity.NPCEntity;

public class NpcRenamePacket {

    public static final Identifier ID = new Identifier(Puppeteer.MODID, "npc_rename");

    public static void send(String name) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeByteArray(name.getBytes());
        ClientPlayNetworking.send(ID, buf);
    }

    public static void handle(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler network, PacketByteBuf buf, PacketSender sender) {

        String name = new String(buf.readByteArray());
        NPCEntity target = NPCHandler.getNPC();

        if (!name.isEmpty() && target != null) {
            server.execute(() -> target.setCustomName(new LiteralText(name)));
        }
    }
}

