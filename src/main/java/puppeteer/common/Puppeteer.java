package puppeteer.common;

import net.fabricmc.api.ModInitializer;
import puppeteer.common.registry.ModEntityTypes;

public class Puppeteer implements ModInitializer {
    public static final String MODID = "puppeteer"; /// it's this ok ?

    @Override
    public void onInitialize() {
      ModEntityTypes.init();
    }
}
