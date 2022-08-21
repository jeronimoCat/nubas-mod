package com.nubasinc.nubasmod.item;

import com.nubasinc.nubasmod.entity.BulletEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FirearmWeaponItem extends Item {
    public FirearmWeaponItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {

        ItemStack inhand = player.getItemInHand(hand);
        ItemStack itemstack = new ItemStack(Items.ARROW);

        if (!world.isClientSide) {
            Vec3 lookVec = player.getLookAngle();
            Vec3 motion = lookVec
                    .normalize()
                    .scale(5);
            BulletEntity bullet = new BulletEntity(world, player);
            bullet.setPos(player.getEyePosition());
            bullet.setDeltaMovement(motion);
            bullet.setOwner(player);
            world.addFreshEntity(bullet);
        }

        world.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (world.getRandom().nextFloat() * 0.4F + 1.2F) + 0.5F);

        return InteractionResultHolder.consume(inhand);
    }
}
