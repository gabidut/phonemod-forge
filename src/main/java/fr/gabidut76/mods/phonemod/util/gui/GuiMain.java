package fr.gabidut76.mods.phonemod.util.gui;

import fr.aym.acsguis.component.layout.GuiScaler;
import fr.aym.acsguis.component.panel.GuiFrame;
import fr.aym.acsguis.component.panel.GuiPanel;
import fr.aym.acsguis.component.textarea.GuiTextArea;
import fr.gabidut76.mods.phonemod.util.Ref;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;
import java.util.List;

public class GuiMain extends GuiFrame {
    public GuiMain(int phoneNumber) {
        super(new GuiScaler.Identity());
        GuiPanel panel = new GuiPanel();

        GuiTextArea message = new GuiTextArea();
        message.setCssId("msg");
        message.setHintText(String.valueOf(phoneNumber));

        panel.add(message);
        add(panel);
    }


        @Override
    public List<ResourceLocation> getCssStyles() {
        return Collections.singletonList(new ResourceLocation(Ref.MODID,"css/config.css"));
    }
}