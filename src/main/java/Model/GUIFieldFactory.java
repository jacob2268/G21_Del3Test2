package Model;

import gui_fields.*;

import java.awt.*;

public class GUIFieldFactory {

    public GUI_Field[] createBoard() {
        return new GUI_Field[]
                {
                        new GUI_Start("Start", "Receive $2, when you pass", "Receive $2, when you pass", Color.white, Color.black),
                        new GUI_Street("Burger Bar", "$1", "Burger Bar", "$1", Color.orange, Color.black),
                        new GUI_Street("PizzaHut", "$1", "PizzaHut", "$1", Color.orange, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Candy Store", "$1", "Candy Store", "$1", Color.getHSBColor(.76f,.8f,.8f), Color.black),
                        new GUI_Street("Ice Cream Store", "$1", "Ice Cream Store", "$1", Color.getHSBColor(.76f,.8f,.8f), Color.black),
                        new GUI_Jail(),
                        new GUI_Street("Museum", "$2", "Museum", "$2", Color.pink, Color.black),
                        new GUI_Street("Library", "$2", "Library", "$2", Color.pink, Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Skate park", "$2", "Skate park", "$2", Color.getHSBColor(3f,0.3f,0.5f), Color.black),
                        new GUI_Street("Swimming Pool", "$2", "Swimming Pool ", "$2", Color.getHSBColor(3f,0.3f,0.5f), Color.black),
                        new GUI_Refuge(),
                        new GUI_Street("Arcade" ,"$3", "Arcade", "$3", Color.getHSBColor(0.5f,0.5f,0.5f), Color.black),
                        new GUI_Street("Cinema", "$3", "Cinema", "$3", Color.getHSBColor(0.5f,0.5f,0.5f), Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Toy Store", "$3", "Toy Store", "$3", Color.cyan, Color.black),
                        new GUI_Street("Pet Shop", "$3", "Pet Shop", "$3", Color.cyan, Color.black),
                        new GUI_Jail(),
                        new GUI_Street("Bowling Alley", "$4", "Bowling Alley", "$4", Color.getHSBColor(0.195f,0.68f,0.37f), Color.black),
                        new GUI_Street("Zoo", "$4", "Zoo", "$4", Color.getHSBColor(0.195f,0.68f,0.37f), Color.black),
                        new GUI_Chance(),
                        new GUI_Street("Water Park", "$4", "Water Park", "$4", Color.getHSBColor(0.64f,0.46f,0.88f), Color.black),
                        new GUI_Street("Beach Walk", "$4", "Beach Walk", "$4", Color.getHSBColor(0.64f,0.46f,0.88f), Color.black)
                };

    }

}
