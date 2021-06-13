package puppeteer.common;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import net.minecraft.text.TranslatableText;
import puppeteer.common.network.packet.NpcRemovePacket;
import puppeteer.common.network.packet.NpcRenamePacket;
import puppeteer.common.registry.ModCommands;
import puppeteer.common.registry.ModEntityTypes;
import puppeteer.common.registry.ModObjects;

public class Puppeteer implements ModInitializer {
    public static final String MODID = "puppeteer";

    @Override
    public void onInitialize() {
        ServerPlayNetworking.registerGlobalReceiver(NpcRenamePacket.ID, NpcRenamePacket::handle);
        ServerPlayNetworking.registerGlobalReceiver(NpcRemovePacket.ID, NpcRemovePacket::handle);

        ModObjects.init();
        ModCommands.init();
        ModEntityTypes.init();
    }

    public static TranslatableText makeTranslation(String key, Object... params) {
        return new TranslatableText(MODID + "." + key, params);
    }

}
