package puppeteer.common.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import puppeteer.common.Puppeteer;
import puppeteer.common.entity.NPCEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModEntityTypes {
  private static final Map<EntityType<?>, Identifier> ENTITY_TYPES = new LinkedHashMap<>();

  public static final EntityType<NPCEntity> NPC = create("default_npc", NPCEntity.createMobAttributes(), FabricEntityTypeBuilder.create(SpawnGroup.MISC, NPCEntity::new).dimensions(EntityDimensions.fixed(0.6F, 1.8F)).trackRangeBlocks(32).trackedUpdateRate(2).build());

  private static <T extends LivingEntity> EntityType<T> create(String name, DefaultAttributeContainer.Builder attributes, EntityType<T> entityType) {
    FabricDefaultAttributeRegistry.register(entityType, attributes);
    ENTITY_TYPES.put(entityType, new Identifier(Puppeteer.MODID, name));
    return entityType;
  }
    private static <T extends Entity> EntityType<T> create(String name, EntityType<T> entityType) {
    ENTITY_TYPES.put(entityType, new Identifier(Puppeteer.MODID, name));
    return entityType;
  }

  public static void init() {
    ENTITY_TYPES.keySet().forEach(entityType -> Registry.register(Registry.ENTITY_TYPE, ENTITY_TYPES.get(entityType), entityType));
  }

    //Old code

  /*
  public static final EntityType<AlexEntity> ALEX_ENTITY = Registry.register(Registry.ENTITY_TYPE,
      new Identifier(Puppeteer.MODID, "alex_entity"), FabricEntityTypeBuilder
          .create(SpawnGroup.CREATURE, AlexEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());

  public static final EntityType<SteveEntity> STEVE_ENTITY = Registry.register(Registry.ENTITY_TYPE,
      new Identifier(Puppeteer.MODID, "steve_entity"), FabricEntityTypeBuilder
          .create(SpawnGroup.CREATURE, SteveEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build()); *

   */

/*
  // here we register the two entities. they are too big, its either the two
  // values in EntityDimension, or the value 0.7 where we register the renderer

  public static void init() {
    FabricDefaultAttributeRegistry.register(ALEX_ENTITY, NPCEntity.createMobAttributes());
    FabricDefaultAttributeRegistry.register(STEVE_ENTITY, NPCEntity.createMobAttributes());
  }

  /*EntityRendererRegistry.INSTANCE.register(ALEX_ENTITY, (dispatcher, context) -> {
    return new AlexEntityRenderer(dispatcher, new PlayerEntityModel<>(0.0F, true), 0.7F);
    // we register the renderer. true makes the armes thin
  });
} *

   */
}

