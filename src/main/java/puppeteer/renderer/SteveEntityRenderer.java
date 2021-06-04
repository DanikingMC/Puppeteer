package puppeteer.renderer;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.util.Identifier;
import puppeteer.common.entity.NPCEntity;

public class SteveEntityRenderer extends MobEntityRenderer<NPCEntity, PlayerEntityModel<NPCEntity>>{

  /**
   * I changed this a little bit
   * My idea is to use NPCEntity as default with steve texture
   * So we don't need to extend it to create steve but to create Alex.
   * I hope you understand what i mean.
   *
   */
  public SteveEntityRenderer(EntityRenderDispatcher entityRenderDispatcher, PlayerEntityModel<NPCEntity> entityModel, float f) {
    super(entityRenderDispatcher, entityModel, f);
  }

  @Override
  public Identifier getTexture(NPCEntity entity) {
    return new Identifier("minecraft", "textures/entity/cube/steve.png");
    //this doesnt work, needs debugging. later we will use a tag for this, to determine which skin we need
  }
  
  // we take the model from PlayerEntity, and use that as our own model, so that we dont have to create our own
}
