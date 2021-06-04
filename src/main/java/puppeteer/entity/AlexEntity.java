package puppeteer.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class AlexEntity extends NPCEntity{

  public AlexEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
    super(entityType, world);
  }
  // we have this class to be able to have 2 different models easily
}
