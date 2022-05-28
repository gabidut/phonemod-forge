package fr.gabidut76.mods.phonemod.util.gui;

import fr.aym.acsguis.component.layout.GuiScaler;
import fr.aym.acsguis.component.panel.GuiFrame;
import fr.aym.acsguis.component.panel.GuiPanel;
import fr.aym.acsguis.component.textarea.GuiLabel;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;
import java.util.List;

public class GuiInCall extends GuiFrame {

    public GuiInCall(int phoneNumber, String name) {
        super(new GuiScaler.Identity());

        GuiPanel home = new GuiPanel();
        home.setCssClass("home");

        GuiPanel refuse = new GuiPanel();
        refuse.setCssClass("refuse");
        refuse.setCssId("refuse");

        GuiPanel screen = new GuiPanel();
        screen.setCssClass("screen");
        screen.setCssId("screen");

        GuiPanel number = new GuiPanel();
        number.setCssClass("number");
        number.add(new GuiLabel(0, 0, 0, 0, Integer.toString(phoneNumber)).setCssId("number"));
        home.add(number);

        GuiPanel author = new GuiPanel();
        author.setCssClass("name");
        author.add(new GuiLabel(0, 0, 0, 0, name).setCssId("name"));
        home.add(author);

        home.add(number);
        home.add(author);
        home.add(refuse);
        home.add(screen);
        add(home);


        refuse.addClickListener((x, y, bu) -> {

        });
    }

    @Override
    public List<ResourceLocation> getCssStyles() {
        return Collections.singletonList(new ResourceLocation("dynamxmod","css/incall.css"));
    }
}

