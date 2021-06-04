package puppeteer.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class NPCEntity extends PathAwareEntity {
  protected NPCEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
    super(entityType, world);
  }
}
