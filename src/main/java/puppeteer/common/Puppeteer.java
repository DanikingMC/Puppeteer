package puppeteer.common;

import net.fabricmc.api.ModInitializer;
import puppeteer.common.registry.ModCommands;
import puppeteer.common.registry.ModObjects;

public class Puppeteer implements ModInitializer {
    public static final String MODID = "puppeteer";

    @Override
    public void onInitialize() {
        ModObjects.init();
        ModCommands.init();
    }
}
