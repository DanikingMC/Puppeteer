package puppeteer.common.network.packet;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
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

public class NpcUpdateTextFieldPacket {

    public static final Identifier ID = new Identifier(Puppeteer.MODID, "update_text_field");

    public static void send(String name) {
        PacketByteBuf buf = PacketByteBufs.create();
        ClientPlayNetworking.send(ID, buf);
    }


    public static void handle(MinecraftClient client, ClientPlayNetworkHandler network, PacketByteBuf buf, PacketSender sender) {

        client.execute(() -> {

        });
    }
}


