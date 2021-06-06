package puppeteer.common.item.wand;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import puppeteer.client.screen.NPCSpawnScreen;
import puppeteer.common.entity.NPCEntity;
import puppeteer.common.registry.ModEntityTypes;

public class PuppeteerWandItem extends Item {
    public PuppeteerWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        //I think this it's easy to understand
        //basically open client screen  when you right click the npc.

        World world = user.world;

        if (world.isClient) {
            openSpawnNPCScreen();
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();

        if (!world.isClient) { //Just in case
           spawnNPC(world, context.getBlockPos(), context.getSide());
        }

        return ActionResult.SUCCESS;
    }

    private void spawnNPC(World world, BlockPos originPos, Direction side) {

        //I need to figure out how to make them spawn facing at you
        //For now they only face south

        NPCEntity entity = ModEntityTypes.NPC.create(world);

        if (world.isClient || entity == null) {
            return;
        } //Only if server side and entity exists

        double dX = originPos.offset(side).getX();
        double dY = originPos.offset(side).getY();
        double dZ = originPos.offset(side).getZ();
        float dYaw = world.random.nextFloat() * 360;
        entity.updatePositionAndAngles(dX, dY, dZ, dYaw,0);
        world.spawnEntity(entity);
    }

    @Environment(EnvType.CLIENT)
    public static void openSpawnNPCScreen() {
        MinecraftClient.getInstance().openScreen(new NPCSpawnScreen());
    }
}
