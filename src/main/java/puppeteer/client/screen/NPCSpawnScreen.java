package puppeteer.client.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import puppeteer.common.Puppeteer;

public class NPCSpawnScreen extends Screen {
    //Texture path
    private final Identifier BACKGROUND = new Identifier(Puppeteer.MODID, "textures/screen/npc_screen.png");

    private int x;
    private int y;

    private TextFieldWidget textField;
    private final Text npcName = new TranslatableText("");

    public NPCSpawnScreen() {
        //what is this for??
        super(new TranslatableText("testing"));
    }

    @Override
    protected void init() {
        this.x = (this.width - 248) / 2;
        this.y = (this.height - 120) / 2;

        this.textField = new TextFieldWidget(this.textRenderer, this.x + ((248 - 195) / 2), this.y + 20, 195, 20, this.npcName);
        this.textField.setMaxLength(32);
        this.addChild(this.textField);
        this.textField.setText(this.npcName.asString());

    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        if (this.client == null) return; //avoid warnings

        //draws background
        this.client.getTextureManager().bindTexture(BACKGROUND);
        byte dY = 30;
        this.renderBackground(matrices);
        this.drawTexture(matrices, this.x, this.y - dY, 0, 0, 248, 167);

        this.textField.render(matrices, mouseX, mouseY, delta);


        // Rename Title
        this.textRenderer.draw(matrices, "Rename your NPC", this.x + 77, this.y - 15, 0x000000);
        this.textRenderer.draw(matrices, "New Name:", this.x + 27, this.y + 5, 0x404040);

        super.render(matrices, mouseX, mouseY, delta);
    }
}
