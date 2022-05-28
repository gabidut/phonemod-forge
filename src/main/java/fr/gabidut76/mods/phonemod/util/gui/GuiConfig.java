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

public class GuiConfig extends GuiFrame {

    public GuiConfig() {
        super(new GuiScaler.Identity());

        GuiPanel home = new GuiPanel();
        home.setCssClass("home");

        GuiPanel screen = new GuiPanel();
        screen.setCssClass("screen");

        GuiTextArea number;
        number = (GuiTextArea) new GuiTextArea(0, 0, 0, 0).setMaxTextLength(10).setHintText("Numéro ex. 0356142265").setCssId("number").setCssClass("number");
        number.setRegexPattern(Pattern.compile(".*[0-9].*"));

        GuiTextArea name;
        name = (GuiTextArea) new GuiTextArea(0, 0, 0, 0).setMaxTextLength(20).setHintText("Nom du téléphone").setCssId("name").setCssClass("name");
        name.setRegexPattern(Pattern.compile(".*[A-Z].*"));

        GuiPanel button = new GuiPanel();
        button.setCssClass("valid");
        button.setCssId("valid");

        GuiPanel error = new GuiPanel();
        error.setCssClass("error");
        //error.add(new GuiLabel(0,0,0,0, "").setCssId("sold"));

        button.addClickListener((x, y, bu) -> {
            if(name.getText().isEmpty() && number.getText().isEmpty()){
                error.add(new GuiLabel(0, 0, 0, 0, "Les champs doivent être remplis.").setCssId("error"));
                home.add(error);
                error.setVisible(true);
            } else {

            }
        });

        home.add(screen);
        home.add(number);
        home.add(name);
        home.add(button);
        add(home);

    }

    @Override
    public List<ResourceLocation> getCssStyles() {
        return Collections.singletonList(new ResourceLocation("dynamxmod","css/config.css"));
    }
}
