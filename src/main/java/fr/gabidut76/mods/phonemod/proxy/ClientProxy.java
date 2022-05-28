package fr.gabidut76.mods.phonemod.proxy;

import fr.aym.acsguis.api.ACsGuiApi;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ClientProxy extends CommonProxy
{

    @Override
    public void registerVariantRenderer(Item item, int meta, String filename, String id) {
        super.registerVariantRenderer(item, meta, filename, id);
    }

    @Override
    public void registerEntityRenderers()
    {
        super.registerEntityRenderers();	
    }

    @Override
    public void preInit()
    {
        ACsGuiApi.registerStyleSheetToPreload(new ResourceLocation("dynamxmod", "css/main.css"));
        ACsGuiApi.registerStyleSheetToPreload(new ResourceLocation("dynamxmod", "css/config.css"));
        super.preInit();
    }
}
