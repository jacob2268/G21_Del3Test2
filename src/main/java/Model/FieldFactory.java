package Model;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class FieldFactory {

    public GUI_Field[] createBoard() {
        return new GUI_Field[]

                {
                        new GUI_Start("Start", "Modtag M2, når du passerer", "Modtag M2, når du passerer", Color.white, Color.black),
                        new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.orange, Color.black),
                        new GUI_Street("Pizzahuset", "M1", " ", "M1", Color.orange, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Slikbutikken", "M1", " ", "M1", Color.blue, Color.white),
                        new GUI_Street("Iskiosken", "M1", " ", "M1", Color.blue, Color.white),
                        new GUI_Jail(),
                        new GUI_Street("Museet", "M1", " ", "M1", Color.pink, Color.black),
                        new GUI_Street("Biblioteket", "M1", " ", "M1", Color.pink, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Skaterparken", "M1", " ", "M1", Color.yellow, Color.black),
                        new GUI_Street("Swimmingpoolen", "M1", " ", "M1", Color.yellow, Color.black),
                        new GUI_Refuge(),
                        new GUI_Street("Spillehallen", "M1", " ", "M1", Color.red, Color.black),
                        new GUI_Street("Biografen", "M1", " ", "M1", Color.red, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Legetøjsbutikken", "M1", " ", "M1", Color.cyan, Color.black),
                        new GUI_Street("Dyrehandlen", "M1", " ", "M1", Color.cyan, Color.black),
                        new GUI_Jail(),
                        new GUI_Street("Bowlinghallen", "M1", " ", "M1", Color.green, Color.black),
                        new GUI_Street("Zoologisk Have", "M1", " ", "M1", Color.green, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Vandlandet", "M1", " ", "M1", Color.magenta, Color.black),
                        new GUI_Street("Strandpromenaden", "M1", " ", "M1", Color.magenta, Color.black)


                };
    }

}
