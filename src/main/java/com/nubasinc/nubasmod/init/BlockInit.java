package com.nubasinc.nubasmod.init;

import com.google.common.collect.EnumBiMap;
import com.nubasinc.nubasmod.NubasMod;
import com.nubasinc.nubasmod.block.MasunyaProp;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NubasMod.MOD_ID);

    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static final RegistryObject<Block> MASUNYA_BLOCK = register("masunya_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_PURPLE).strength(2.0f)
                    .sound(SoundType.AMETHYST).requiresCorrectToolForDrops()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(NubasMod.NUBAS_TAB)));

    public static final RegistryObject<Block> MASUNYA_PROP = register("masunya_prop", () -> new MasunyaProp(BlockBehaviour.Properties.copy(Blocks.DIRT).dynamicShape().sound(SoundType.AMETHYST).noOcclusion()),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(NubasMod.NUBAS_TAB)));

    private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block)
    {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item)
    {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }
}
