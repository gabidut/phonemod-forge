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

public class GuiMain extends GuiFrame {

    String composed_number = "";

    public GuiMain(int phoneNumber) {
        super(new GuiScaler.Identity());

        GuiPanel home = new GuiPanel();
        home.setCssClass("home");
        GuiPanel one = new GuiPanel();
        one.setCssClass("1");
        one.setCssId("1");

        GuiPanel two = new GuiPanel();
        two.setCssClass("2");
        two.setCssId("2");

        GuiPanel three = new GuiPanel();
        three.setCssClass("3");
        three.setCssId("3");

        GuiPanel four = new GuiPanel();
        four.setCssClass("4");
        four.setCssId("4");

        GuiPanel five = new GuiPanel();
        five.setCssClass("5");
        five.setCssId("5");

        GuiPanel six = new GuiPanel();
        six.setCssClass("6");
        six.setCssId("6");

        GuiPanel seven = new GuiPanel();
        seven.setCssClass("7");
        seven.setCssId("7");

        GuiPanel eight = new GuiPanel();
        eight.setCssClass("8");
        eight.setCssId("8");

        GuiPanel nine = new GuiPanel();
        nine.setCssClass("9");
        nine.setCssId("9");

        GuiPanel zero = new GuiPanel();
        zero.setCssClass("0");
        zero.setCssId("0");

        GuiPanel sharp = new GuiPanel();
        sharp.setCssClass("sharp");
        sharp.setCssId("sharp");

        GuiPanel star = new GuiPanel();
        star.setCssClass("star");
        star.setCssId("star");

        GuiPanel accept = new GuiPanel();
        accept.setCssClass("accept");
        accept.setCssId("accept");

        GuiPanel refuse = new GuiPanel();
        refuse.setCssClass("refuse");
        refuse.setCssId("refuse");

        GuiPanel screen = new GuiPanel();
        screen.setCssClass("screen");
        screen.setCssId("screen");

        GuiTextArea compose;
        compose = (GuiTextArea) new GuiTextArea(0, 0, 0, 0).setMaxTextLength(10).setHintText("0").setCssId("number").setCssClass("number");
        compose.setRegexPattern(Pattern.compile(".*[0-9].*"));

//        GuiPanel compose = new GuiPanel();
//        compose.setCssClass("number");
//        compose.add(new GuiLabel(0,0,0,0, composed_number).setCssId("number"));

        home.add(one);
        home.add(two);
        home.add(three);
        home.add(four);
        home.add(five);
        home.add(six);
        home.add(seven);
        home.add(eight);
        home.add(nine);
        home.add(zero);
        home.add(sharp);
        home.add(star);
        home.add(accept);
        home.add(refuse);
        home.add(screen);
        home.add(compose);
        add(home);

        one.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "1");
        });

        two.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "2");
        });

        three.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "3");
        });

        four.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "4");
        });

        five.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "5");
        });

        six.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "6");
        });

        seven.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "7");
        });

        eight.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "8");
        });

        nine.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "9");
        });

        zero.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "0");
        });

        sharp.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "#");
        });

        star.addClickListener((x, y, bu) -> {
            compose.setText(compose.getText() + "*");
        });

        accept.addClickListener((x, y, bu) -> {

            // Code.
        });
    }

        @Override
    public List<ResourceLocation> getCssStyles() {
        return Collections.singletonList(new ResourceLocation("dynamxmod","css/main.css"));
    }
}
