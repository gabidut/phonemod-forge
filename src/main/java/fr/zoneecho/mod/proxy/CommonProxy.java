package fr.zoneecho.mod.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy
{

    public void registerItemRenderer(Item item, int meta)
    {

    }

    public void registerVariantRenderer(Item item, int meta, String filename, String id)
    {

    }

    public void registerEntityRenderers()
    {

    }

    public void preInit()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
