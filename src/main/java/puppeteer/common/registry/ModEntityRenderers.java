package puppeteer.common.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import puppeteer.client.renderer.SteveEntityRenderer;

@Environment(EnvType.CLIENT)
public class ModEntityRenderers {

    public static void initClient(){
        EntityRendererRegistry.INSTANCE.register(ModEntityTypes.NPC, (dispatcher, context) -> new SteveEntityRenderer(dispatcher, new PlayerEntityModel<>(0.0F, false), 0.7F));
    }
}
