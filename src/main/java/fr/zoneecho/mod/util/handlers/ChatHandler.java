package fr.zoneecho.mod.util.handlers;

import fr.zoneecho.mod.util.Ref;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = Ref.MODID)
public class ChatHandler {
    @SubscribeEvent
    public static void OnChat(ServerChatEvent e) {

        if(Objects.equals(e.getMessage(), "gabidut le best")) {
            e.setCanceled(true);
            e.getPlayer().sendMessage(new TextComponentString(TextFormatting.GREEN + "J'approuve !"));
        }
    }
}