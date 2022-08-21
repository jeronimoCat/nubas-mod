package com.nubasinc.nubasmod.init;

import com.nubasinc.nubasmod.NubasMod;
import com.nubasinc.nubasmod.entity.BulletEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, NubasMod.MOD_ID);

    public static final RegistryObject<EntityType<BulletEntity>> BULLET_ENTITY =
            ENTITIES.register("bullet_entity",
                    () -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .build(new ResourceLocation(NubasMod.MOD_ID, "bullet_entity").toString()));

    private static <T extends EntityType<?>> RegistryObject<T> register(final String name, final Supplier<T> entity)
    {
        return ENTITIES.register(name, entity);
    }
}
