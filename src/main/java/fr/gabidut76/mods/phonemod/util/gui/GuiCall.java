package fr.gabidut76.mods.phonemod.util.gui;

import fr.aym.acsguis.component.layout.GuiScaler;
import fr.aym.acsguis.component.panel.GuiFrame;
import fr.aym.acsguis.component.panel.GuiPanel;
import fr.aym.acsguis.component.textarea.GuiLabel;
import fr.aym.acsguis.component.textarea.GuiTextArea;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class GuiCall extends GuiFrame {


    public GuiCall(int phoneNumber, String name) {
        super(new GuiScaler.Identity());

        GuiPanel home = new GuiPanel();
        home.setCssClass("home");

        GuiPanel accept = new GuiPanel();
        accept.setCssClass("accept");
        accept.setCssId("accept");

        GuiPanel refuse = new GuiPanel();
        refuse.setCssClass("refuse");
        refuse.setCssId("refuse");

        GuiPanel screen = new GuiPanel();
        screen.setCssClass("screen");
        screen.setCssId("screen");

//        GuiPanel compose = new GuiPanel();
//        compose.setCssClass("number");
//        compose.add(new GuiLabel(0,0,0,0, composed_number).setCssId("number"));

        home.add(accept);
        home.add(refuse);
        home.add(screen);
        add(home);

        accept.addClickListener((x, y, bu) -> {

            // Code.
        });

        refuse.addClickListener((x, y, bu) -> {

        });
    }

    @Override
    public List<ResourceLocation> getCssStyles() {
        return Collections.singletonList(new ResourceLocation("dynamxmod","css/call.css"));
    }
}
