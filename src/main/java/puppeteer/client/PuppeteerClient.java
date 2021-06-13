package puppeteer.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import puppeteer.client.screen.gui.GuiNpc;
import puppeteer.common.registry.ModEntityRenderers;
import puppeteer.common.registry.ModScreenHandlers;

@Environment(EnvType.CLIENT)
public class PuppeteerClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModEntityRenderers.initClient();
        ScreenRegistry.register(ModScreenHandlers.NPC_HANDLER, GuiNpc::new);
    }
}
