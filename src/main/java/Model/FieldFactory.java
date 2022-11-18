package Model;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class FieldFactory {

    public GUI_Field[] createBoard() {
        return new GUI_Field[]

                {
                        new GUI_Start("Start", "Modtag $2, når du passerer", "Modtag M2, når du passerer", Color.white, Color.black),
                        new GUI_Street("Burgerbaren", "$1", " Burgerbaren ", "$1", Color.orange, Color.black),
                        new GUI_Street("Pizzahuset", "$1", "Pizzaria ", "$1", Color.orange, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Slikbutikken", "$1", "Slikbutikken ", "$1", Color.blue, Color.white),
                        new GUI_Street("Iskiosken", "$1", "Iskiosken ", "$1", Color.blue, Color.white),
                        new GUI_Jail(),
                        new GUI_Street("Museet", "$2", " Museet", "$1", Color.pink, Color.black),
                        new GUI_Street("Biblioteket", "$2", "Bibloteket ", "$1", Color.pink, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Skaterparken", "$2", " Skaterparken", "$2", Color.yellow, Color.black),
                        new GUI_Street("Swimmingpoolen", "$2", "Swimmingpoolen ", "$2", Color.yellow, Color.black),
                        new GUI_Refuge(),
                        new GUI_Street("Spillehallen", "$3", "Spillehallen ", "$3", Color.red, Color.black),
                        new GUI_Street("Biografen", "$3", "Biografen ", "$3", Color.red, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Legetøjsbutikken", "$3", "Legetøjsbutikken ", "$3", Color.cyan, Color.black),
                        new GUI_Street("Dyrehandlen", "$3", "Dyrehandlen ", "$3", Color.cyan, Color.black),
                        new GUI_Jail(),
                        new GUI_Street("Bowlinghallen", "$4", "Bowlinghallen", "$4", Color.green, Color.black),
                        new GUI_Street("Zoologisk Have", "$4", "Zoologisk Have ", "$4", Color.green, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Vandlandet", "$4", "Vandlandet ", "$4", Color.magenta, Color.black),
                        new GUI_Street("Strandpromenaden", "$4", "Strandpromenaden ", "$4", Color.magenta, Color.black)


                };
    }

}
