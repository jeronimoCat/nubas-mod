package com.nubasinc.nubasmod;

import com.nubasinc.nubasmod.init.BlockInit;
import com.nubasinc.nubasmod.init.EntityInit;
import com.nubasinc.nubasmod.init.ItemInit;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("nubasmod")
public class NubasMod
{
    public static final String MOD_ID = "nubasmod";

    public void clientSetup(final FMLClientSetupEvent event)
    {
        EntityRenderers.register(EntityInit.BULLET_ENTITY.get(), (context) -> {
            return new ThrownItemRenderer<>(context, 1.0F, true);
        });
    };
    public static final CreativeModeTab NUBAS_TAB = new CreativeModeTab("nubas_tab") {
        @Override
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.NUBAS_ITEM.get());
        }
    };
    public NubasMod()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        EntityInit.ENTITIES.register(bus);

        bus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);

    }
}
