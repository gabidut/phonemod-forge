package fr.gabidut76.mods.phonemod.network;

import fr.gabidut76.mods.phonemod.PhoneMod;
import fr.gabidut76.mods.phonemod.util.network.PacketMainMenu;
import fr.gabidut76.mods.phonemod.util.network.PacketOpenConfig;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class Network {
    public static void init(){
        PhoneMod.network = NetworkRegistry.INSTANCE.newSimpleChannel("phonemod");
        PhoneMod.network.registerMessage(PacketOpenConfig.Handler.class, PacketOpenConfig.class, 0, Side.CLIENT);
        PhoneMod.network.registerMessage(PacketMainMenu.Handler.class, PacketMainMenu.class, 1, Side.CLIENT);
    }
}
