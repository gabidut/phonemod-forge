package fr.zoneecho.mod.util.gui;

import fr.aym.acsguis.component.button.GuiButton;
import fr.aym.acsguis.component.layout.GuiScaler;
import fr.aym.acsguis.component.panel.GuiFrame;
import fr.aym.acsguis.component.panel.GuiPanel;
import fr.aym.acsguis.component.textarea.GuiTextArea;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;
import java.util.List;

public class GuiBroadcast extends GuiFrame {
    public GuiBroadcast() {
        super(new GuiScaler.Identity());
        GuiPanel panel = new GuiPanel();

        GuiTextArea message = new GuiTextArea();
        message.setCssId("msg");
        message.setHintText("Inserez votre message...");

        GuiButton val = new GuiButton();
        val.setCssId("val");
        val.setText("Valider");


        panel.add(message);
        panel.add(val);
        panel.setCssId("panel");
        add(panel);
    }


        @Override
    public List<ResourceLocation> getCssStyles() {
        return Collections.singletonList(new ResourceLocation("zoneecho","css/broadcast.css"));
    }
}
