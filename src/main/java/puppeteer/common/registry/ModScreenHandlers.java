package puppeteer.common.registry;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import puppeteer.client.screen.handler.NPCHandler;
import puppeteer.common.Puppeteer;

public class ModScreenHandlers {

    public static final ScreenHandlerType<NPCHandler> NPC_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Puppeteer.MODID, "npc_screen"), NPCHandler::new);

}
