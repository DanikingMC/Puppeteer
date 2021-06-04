package puppeteer.renderer;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;
import puppeteer.entity.AlexEntity;

public class AlexEntityRenderer extends MobEntityRenderer<AlexEntity, PlayerEntityModel<AlexEntity>> {

  public AlexEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, PlayerEntityModel<AlexEntity> entityModel,
      float f) {
    super(entityRenderDispatcher, entityModel, f);
  }

  @Override
  public Identifier getTexture(AlexEntity entity) {
    return new Identifier("minecraft", "textures/entity/cube/alex.png");
    //this doesnt work, needs debugging. later we will use a tag for this, to determine which skin we need
  }

  // we take the model from PlayerEntity, and use that as our own model, so that we dont have to create our own
}
