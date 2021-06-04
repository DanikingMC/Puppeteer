package puppeteer.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class NPCEntity extends PathAwareEntity {

  //----------Default NPCEntity class--------------------//
  //this entity should have steve skin
  //then we only need to extend this to create alex or someone else

  public NPCEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
    super(entityType, world);
  }


  // we will implement behavior here, so that the alex and steve npc always do the same stuff


  @Override
  public void tick() {
    super.tick(); //I knew they had a tick()!
  }

}
