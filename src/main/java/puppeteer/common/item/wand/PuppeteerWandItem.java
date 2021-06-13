package puppeteer.common.item.wand;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import puppeteer.client.screen.handler.NPCHandler;
import puppeteer.common.entity.NPCEntity;
import puppeteer.common.registry.ModEntityTypes;

public class PuppeteerWandItem extends Item {
    public PuppeteerWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (entity != null) {
            if (entity instanceof NPCEntity) {
                 user.openHandledScreen(handler(stack, (NPCEntity) entity));
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }

    private static NamedScreenHandlerFactory handler(ItemStack stack, NPCEntity npc) {
        return new SimpleNamedScreenHandlerFactory(((syncId, inv, player) -> new NPCHandler(syncId, inv, npc)), stack.getName());
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        spawnNPC(world, context.getBlockPos(), context.getSide());
        return ActionResult.SUCCESS;
    }

    public static void spawnNPC(World world, BlockPos originPos, Direction side) {

        //I need to figure out how to make them spawn facing at you
        //For now they only face south

        NPCEntity entity = ModEntityTypes.NPC.create(world);

        if (entity == null) {
            return;
        }

        double dX = originPos.offset(side).getX();
        double dY = originPos.offset(side).getY();
        double dZ = originPos.offset(side).getZ();
        float dYaw = world.random.nextFloat() * 360;
        entity.updatePositionAndAngles(dX, dY + 1, dZ, dYaw,0);//Dy + 1 makes the fall animation, i took it from another mod lol
        world.spawnEntity(entity);
    }

}
