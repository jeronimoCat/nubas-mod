package com.nubasinc.nubasmod.entity;

import com.nubasinc.nubasmod.init.EntityInit;
import com.nubasinc.nubasmod.init.ItemInit;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class BulletEntity extends AbstractHurtingProjectile implements ItemSupplier {
    public BulletEntity(EntityType<? extends BulletEntity> entityType, Level level) {
        super(entityType, level);
    }

    public BulletEntity(EntityType<? extends AbstractHurtingProjectile> entityType, double p_36818_, double p_36819_, double p_36820_, double p_36821_, double p_36822_, double p_36823_, Level p_36824_) {
        super(entityType,p_36818_,p_36819_,p_36820_,p_36821_,p_36822_,p_36823_,p_36824_);

    }

    public BulletEntity(EntityType<? extends AbstractHurtingProjectile> entityType, LivingEntity livingEntity, double p_36828_, double p_36829_, double p_36830_, Level p_36831_) {
        super(entityType,livingEntity,p_36828_,p_36829_,p_36830_,p_36831_);
    }

    public BulletEntity(Level level, LivingEntity entity) {
        super(EntityInit.BULLET_ENTITY.get(), level);
    }

    @Override
    public void tick() {
        if(this.isInLava())
        {
            kill();
        }
        setDeltaMovement(getDeltaMovement().add(0, -0.01, 0));
        super.tick();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!this.level.isClientSide) {
            Entity entity = result.getEntity();
            Entity owner = this.getOwner();
            entity.hurt(DamageSource.playerAttack((Player)owner), 5.0F);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult ray) {
        super.onHitBlock(ray);
        kill();
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(ItemInit.NUBAS_ITEM.get());
    }

    @Override
    protected boolean shouldBurn() {
        return false;
    }

    @Override
    public boolean isInWater() {
        return false;
    }
}
