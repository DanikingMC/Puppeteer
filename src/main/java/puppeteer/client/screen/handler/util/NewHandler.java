package puppeteer.client.screen.handler.util;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.jetbrains.annotations.Nullable;

public class NewHandler extends ScreenHandler {

    protected NewHandler(@Nullable ScreenHandlerType<?> type, int syncId) {
        super(type, syncId);
    }

    /*
     * I don't want to override this, every time I create
     *  a new handler for the screen >_<
     */

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}
