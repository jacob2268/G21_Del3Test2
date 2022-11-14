package Model;

import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class FieldFactory {

    public GUI_Field[] createBoard() {
        return new GUI_Field[]

                {
                        new GUI_Start("Start", "Modtag M2, når du passerer", "Modtag M2, når du passerer", Color.red, Color.white),
                        new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.orange, Color.white),
                        new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.orange, Color.white),
                        new GUI_Chance(),
                        new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.blue, Color.white),
                        new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.blue, Color.white),
                        new GUI_Jail(),
                        new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.pink, Color.white),
                        new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.pink, Color.white),
                        new GUI_Chance(),
                         new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.yellow, Color.white),
                         new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.yellow, Color.white),
                         new GUI_Refuge(),
                         new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.red, Color.white),
                         new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.red, Color.white),
                         new GUI_Chance(),
                         new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.cyan, Color.white),
                         new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.cyan, Color.white),
                         new GUI_Street("Fængsel", "På besøg", " ", "", Color.darkGray, Color.white),
                         new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.green, Color.white),
                        new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.green, Color.white),
                         new GUI_Chance(),
                         new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.magenta, Color.white),
                         new GUI_Street("Burgerbaren", "M1", " ", "M1", Color.magenta, Color.white)


                };
    }

}
