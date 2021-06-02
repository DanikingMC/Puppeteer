package puppeteer.common.registry;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;
import com.mojang.brigadier.CommandDispatcher;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;

public class ModCommands {
  public static void init() {
    CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
      opMe(dispatcher);
    });
  }

  private static void opMe(CommandDispatcher<ServerCommandSource> dispatcher) {
    // we need this command later, gradlew runserver doesnt allow you to run commands, this is the only way to get op
    dispatcher.register(literal("opme")
      .executes(ctx -> {
        ctx.getSource().getMinecraftServer().getPlayerManager().addToOperators(ctx.getSource().getPlayer().getGameProfile());
        return 0;
      })
    );
  }
}
