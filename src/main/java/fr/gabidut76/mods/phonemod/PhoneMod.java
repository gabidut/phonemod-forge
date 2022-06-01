package fr.gabidut76.mods.phonemod;


import fr.aym.acsguis.api.ACsGuiApi;
import fr.dynamx.api.contentpack.DynamXAddon;
import fr.gabidut76.mods.phonemod.network.Network;
import fr.gabidut76.mods.phonemod.objects.blocks.BlockDynxPhone;
import fr.gabidut76.mods.phonemod.objects.tiles.TilePhone;
import fr.gabidut76.mods.phonemod.proxy.CommonProxy;
import fr.gabidut76.mods.phonemod.tabs.MainTab;
import fr.gabidut76.mods.phonemod.util.Ref;
import fr.gabidut76.mods.phonemod.util.command.CommandPhoneMod;
import fr.gabidut76.mods.phonemod.util.handlers.SpeakHandler;
import fr.gabidut76.mods.phonemod.util.network.PacketMainMenu;
import fr.gabidut76.mods.phonemod.util.network.PacketOpenConfig;
import fr.nathanael2611.simpledatabasemanager.core.Database;
import fr.nathanael2611.simpledatabasemanager.core.Databases;
import fr.nathanael2611.simpledatabasemanager.core.SyncedDatabases;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.Logger;

@DynamXAddon(modid = Ref.MODID, name = "phonemod", version = Ref.VERSION)
@Mod(modid = Ref.MODID, name = Ref.NAME, version = Ref.VERSION, dependencies = "before: dynamxmod;after: sdm;required-after:modularvc")
@Mod.EventBusSubscriber(modid = Ref.MODID)
public class PhoneMod {

    public static final CreativeTabs PhoneModTab = new MainTab("PhoneMod");

    @SidedProxy(clientSide = Ref.CLIENT, serverSide = Ref.COMMON)
    public static CommonProxy proxy;
    public static SimpleNetworkWrapper network;
    public static Logger logger;
    public static Database dbPhones;
    public static Database dbPhonesRing;



    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {

        logger = e.getModLog();
        proxy.preInit();
        /* network */
        Network.init();
        if(e.getSide().isClient()) {
            ACsGuiApi.registerStyleSheetToPreload(new ResourceLocation(Ref.MODID, "css/config.css"));
        }
        SyncedDatabases.add("phonemod_data");
        dbPhones = Databases.getDatabase("phonemod_data");

        SyncedDatabases.add("phonemod_ring");
        dbPhonesRing = Databases.getDatabase("phonemod_ring");


        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(SpeakHandler.class);
    }
    public static BlockDynxPhone phoneblock;

     @DynamXAddon.AddonEventSubscriber
     public static void init() {
          System.out.println("Init DynamXAddon.");
         phoneblock = new BlockDynxPhone(Material.ANVIL, Ref.MODID, "Téléphone", "phone/phone.obj");

     }
    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {
        GameRegistry.registerTileEntity(TilePhone.class, new ResourceLocation(Ref.MODID, "phonemod"));

    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandPhoneMod());
    }
}


