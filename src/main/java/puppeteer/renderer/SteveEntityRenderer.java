package puppeteer.renderer;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;
import puppeteer.entity.SteveEntity;

public class SteveEntityRenderer extends MobEntityRenderer<SteveEntity, PlayerEntityModel<SteveEntity>>{

  public SteveEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, PlayerEntityModel<SteveEntity> entityModel,
      float f) {
    super(entityRenderDispatcher, entityModel, f);
  }

  @Override
  public Identifier getTexture(SteveEntity entity) {
    return new Identifier("minecraft", "textures/entity/cube/steve.png");
  }
  
}
