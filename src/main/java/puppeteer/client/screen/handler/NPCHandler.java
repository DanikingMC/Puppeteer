package puppeteer.client.screen.handler;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import puppeteer.client.screen.handler.util.NewHandler;
import puppeteer.common.entity.NPCEntity;
import puppeteer.common.registry.ModScreenHandlers;

public class NPCHandler extends NewHandler {

    private static NPCEntity npcEntity;

    public NPCHandler(int syncId, PlayerInventory playerInventory){
        this(syncId, playerInventory, getNPC());
    }

    public NPCHandler(int syncID, PlayerInventory playerInventory, NPCEntity entity){
        super(ModScreenHandlers.NPC_HANDLER, syncID);
        npcEntity = entity;
    }

    public static NPCEntity getNPC() {
        return npcEntity;
    }

    public static Text getNpcName() {
      return npcEntity.getCustomName();
    }
}
