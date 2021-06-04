package puppeteer.common.registry;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import puppeteer.common.Puppeteer;
import puppeteer.entity.AlexEntity;
import puppeteer.entity.NPCEntity;
import puppeteer.entity.SteveEntity;
import puppeteer.renderer.AlexEntityRenderer;
import puppeteer.renderer.SteveEntityRenderer;

public class ModEntityTypes {
  public static final EntityType<AlexEntity> ALEX_ENTITY = Registry.register(Registry.ENTITY_TYPE,
      new Identifier(Puppeteer.MODID, "alex_entity"), FabricEntityTypeBuilder
          .create(SpawnGroup.CREATURE, AlexEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());

  public static final EntityType<SteveEntity> STEVE_ENTITY = Registry.register(Registry.ENTITY_TYPE,
      new Identifier(Puppeteer.MODID, "steve_entity"), FabricEntityTypeBuilder
          .create(SpawnGroup.CREATURE, SteveEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());

  // here we register the two entities. they are too big, its either the two
  // values in EntityDimension, or the value 0.7 where we register the renderer

  public static void init() {
    FabricDefaultAttributeRegistry.register(ALEX_ENTITY, NPCEntity.createMobAttributes());
    FabricDefaultAttributeRegistry.register(STEVE_ENTITY, NPCEntity.createMobAttributes());
  }

  public static void initClient() {
    EntityRendererRegistry.INSTANCE.register(STEVE_ENTITY, (dispatcher, context) -> {
      return new SteveEntityRenderer(dispatcher, new PlayerEntityModel<>(0.0F, false), 0.7F);
      // we register the renderer. false makes the arms fat
    });
    EntityRendererRegistry.INSTANCE.register(ALEX_ENTITY, (dispatcher, context) -> {
      return new AlexEntityRenderer(dispatcher, new PlayerEntityModel<>(0.0F, true), 0.7F);
      // we register the renderer. true makes the armes thin
    });
  }
}
