package puppeteer.client;

import net.fabricmc.api.ClientModInitializer;
import puppeteer.common.registry.ModEntityTypes;


public class PuppeteerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
      ModEntityTypes.initClient();
      ModEntityTypes.init();
      //ScreenRegistry.register(ModScreenHandlers.NPC_HANDLER, NPCScreen::new); <- Hopefully we don't need a handler anymore

    }
}
