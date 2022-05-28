package fr.gabidut76.mods.phonemod.util.gui;

import fr.aym.acsguis.component.layout.GuiScaler;
import fr.aym.acsguis.component.panel.GuiFrame;
import fr.aym.acsguis.component.panel.GuiPanel;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;
import java.util.List;

public class GuiConfig extends GuiFrame {

    public GuiConfig() {
        super(new GuiScaler.Identity());

        GuiPanel home = new GuiPanel();
        home.setCssClass("home");



        add(home);

    }

    @Override
    public List<ResourceLocation> getCssStyles() {
        return Collections.singletonList(new ResourceLocation("dynamxmod","css/config.css"));
    }
}
