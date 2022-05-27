package fr.gabidut76.mods.phonemod.util.handlers;

import fr.nathanael2611.modularvoicechat.api.VoiceDispatchEvent;
import fr.nathanael2611.simpledatabasemanager.core.Database;
import fr.nathanael2611.simpledatabasemanager.core.Databases;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class SpeakHandler {
    @SubscribeEvent
    public void onStartedSpeak(VoiceDispatchEvent event) {
        Database db = Databases.getPlayerData(event.getSpeaker());
    }
}
