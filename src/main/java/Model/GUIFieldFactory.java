package Model;

import gui_fields.*;

import java.awt.*;

public class GUIFieldFactory {

    public GUI_Field[] createBoard() {
        return new GUI_Field[]

                // alt skal rettes til engelsk
                {
                        new GUI_Start("Start", "Receive $2, når du passerer", "Modtag M2, når du passerer", Color.white, Color.black),
                        new GUI_Street("Burger Bar", "$1", "Burger Bar", "$1", Color.orange, Color.black),
                        new GUI_Street("PizzaHut", "$1", "Pizzaria ", "$1", Color.orange, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Candy Store", "$1", "Slikbutikken ", "$1", Color.getHSBColor(.76f,.8f,.8f), Color.black),
                        new GUI_Street("Ice Cream Store", "$1", "Iskiosken ", "$1", Color.getHSBColor(.76f,.8f,.8f), Color.black),
                        new GUI_Jail(),
                        new GUI_Street("Museum", "$2", " Museet", "$2", Color.pink, Color.black),
                        new GUI_Street("Library", "$2", "Bibloteket ", "$2", Color.pink, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Skate park", "$2", " Skaterparken", "$2", Color.getHSBColor(3f,0.3f,0.5f), Color.black),
                        new GUI_Street("Swimming Pool", "$2", "Swimmingpoolen ", "$2", Color.getHSBColor(3f,0.3f,0.5f), Color.black),
                        new GUI_Refuge(),
                        new GUI_Street("Arcade", "$3", "Spillehallen ", "$3", Color.getHSBColor(0.5f,0.5f,0.5f), Color.black),
                        new GUI_Street("Cinema", "$3", "Biografen ", "$3", Color.getHSBColor(0.5f,0.5f,0.5f), Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Toy Store", "$3", "Legetøjsbutikken ", "$3", Color.cyan, Color.black),
                        new GUI_Street("Pet Shop", "$3", "Dyrehandlen ", "$3", Color.cyan, Color.black),
                        new GUI_Jail(),
                        new GUI_Street("Bowling Alley", "$4", "Bowlinghallen", "$4", Color.getHSBColor(0.195f,0.68f,0.37f), Color.black),
                        new GUI_Street("Zoo", "$4", "Zoologisk Have ", "$4", Color.getHSBColor(0.195f,0.68f,0.37f), Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Water Park", "$4", "Vandlandet ", "$4", Color.magenta, Color.black),
                        new GUI_Street("Beach Walk", "$4", "Strandpromenaden ", "$4", Color.magenta, Color.black)
                };

    }

}
