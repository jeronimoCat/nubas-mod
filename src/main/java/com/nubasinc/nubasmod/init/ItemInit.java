package com.nubasinc.nubasmod.init;

import com.google.common.util.concurrent.ClosingFuture;
import com.nubasinc.nubasmod.NubasMod;
import com.nubasinc.nubasmod.item.AmmoItem;
import com.nubasinc.nubasmod.item.FirearmWeaponItem;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NubasMod.MOD_ID);

    public static final RegistryObject<Item> NUBAS_ITEM = register("nubas_item", () -> new Item(new Item.Properties().tab(NubasMod.NUBAS_TAB)));
    //public static final RegistryObject<Item> AMMO_ITEM = register("nubas_item", () -> new AmmoItem(new Item.Properties().tab(NubasMod.NUBAS_TAB)));
    public static final RegistryObject<Item> FIREARM_WEAPON_ITEM = register("firearm_weapon_item", () -> new FirearmWeaponItem(new Item.Properties().tab(NubasMod.NUBAS_TAB)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item)
    {
        return ITEMS.register(name, item);
    }
}
