package puppeteer.common.item.wand;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import puppeteer.client.screen.NPCSpawnScreen;

public class PuppeteerWandItem extends Item {
    public PuppeteerWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //I think this it's easy to understand
        //basically open client screen on use

        if (world.isClient) {
            openSpawnNPCScreen();
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        //we need a way to spawn the entity here
        //then if success, open GUI
        //and select the name, skin and attributes of npc
        return ActionResult.SUCCESS;
    }

    @Environment(EnvType.CLIENT)
    public static void openSpawnNPCScreen() {
        MinecraftClient.getInstance().openScreen(new NPCSpawnScreen());
    }
}
