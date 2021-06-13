package puppeteer.client.screen.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import puppeteer.client.screen.button.ModScreenButtons;
import puppeteer.client.screen.handler.NPCHandler;
import puppeteer.common.Puppeteer;
import puppeteer.common.entity.NPCEntity;
import puppeteer.common.network.packet.NpcRemovePacket;
import puppeteer.common.network.packet.NpcRenamePacket;
import puppeteer.common.network.packet.NpcUpdateTextFieldPacket;

@Environment(EnvType.CLIENT)
public class GuiNpc extends HandledScreen<NPCHandler> {

    private static final Identifier BACKGROUND = new Identifier(Puppeteer.MODID, "textures/screen/npc_screen.png");

    private TextFieldWidget textField;

    public GuiNpc(NPCHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }


    @Override
    protected void init() {
        super.init();
        x = (width - 248) / 2;
        y = (height - 120) / 2;
        textField = new TextFieldWidget(textRenderer, x + ((248 - 195) / 2), y + 20, 195, 20, new TranslatableText(""));
        addChild(textField);
        SoundManager makeSound = MinecraftClient.getInstance().getSoundManager();
        NPCEntity target = NPCHandler.getNPC();
        textField.setText("");


        //Save
        addButton(new ModScreenButtons(95 + x, y + 100, 60,20,  new TranslatableText("puppeteer.npc_screen_save"), button ->  {
            button.playDownSound(makeSound);
           onClose();
            NpcRenamePacket.send(textField.getText());
        }));
        //Remove entity
        addButton(new ModScreenButtons(165 + x, y + 100, 60, 20, new TranslatableText("puppeteer.npc_screen_remove"), button -> {
            button.playDownSound(makeSound);
            NpcRemovePacket.send();
            onClose();
        }));

        addButton(new ModScreenButtons(25 + x, y + 100, 60, 20, new TranslatableText("puppeteer.npc_screen_reset"), button -> {
            button.playDownSound(makeSound);
            onClose();
        }));

       setInitialFocus(textField);

    }


    @Override
    public void tick() {
        super.tick();
        this.textField.tick();
    }


    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        switch (keyCode) {
            case GLFW.GLFW_KEY_ESCAPE:
                if (shouldCloseOnEsc()) {
                    onClose();
                    return true;
                }
                break;
            case GLFW.GLFW_KEY_TAB:
                boolean isShiftDown = !hasShiftDown();
                if (changeFocus(isShiftDown)) {
                    changeFocus(isShiftDown);
                }
                return false;
            case GLFW.GLFW_KEY_ENTER:
                NpcRenamePacket.send(textField.getText());
                break;
        }
       return this.getFocused() != null && this.getFocused().keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.x = (this.width - 248) / 2;
        this.y = (this.height - 120) / 2;

        if (client == null) {
            return;
        }
        this.client.getTextureManager().bindTexture(BACKGROUND);
        byte dY = 30;
        this.drawTexture(matrices, this.x, this.y - dY, 0, 0, 248, 167);
        this.textField.render(matrices, mouseX, mouseY, delta);


        this.textRenderer.draw(matrices, "Name:", this.x + 27, this.y + 5, 0x404040);

    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {

    }
}
