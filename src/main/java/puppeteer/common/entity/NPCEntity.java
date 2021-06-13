package puppeteer.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class NPCEntity extends PathAwareEntity {

  public NPCEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
    super(entityType, world);
  }

  @Override
  public void tick() {
    super.tick();
  }

  @Override
  public boolean shouldRenderName() {
    return true;
  }

  @Override
  public boolean isCustomNameVisible() {
    return true;
  }

  @Override
  public Text getDefaultName() {
    return new TranslatableText("Steve");
  }

}
