package puppeteer.client;

import net.fabricmc.api.ClientModInitializer;
import puppeteer.common.registry.ModEntityTypes;


public class PuppeteerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
      ModEntityTypes.initClient();
    }
}
