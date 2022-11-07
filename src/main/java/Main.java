import gui_fields.*;
import gui_main.GUI;

import static java.awt.Color.blue;
import static java.awt.Color.white;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();



        GUI_Player player = new GUI_Player("Jacob",1000);
        gui.addPlayer(player);
        GUI_Player player2 = new GUI_Player("Tommy",1000);
        gui.addPlayer(player2);

        player.setBalance(10000);

        GUI_Field field = gui.getFields()[4];
        player.getCar().setPosition(field);
        GUI_Field field2 = gui.getFields()[0];
        player2.getCar().setPosition(field2);

        gui.setDice(1,2);

        field = gui.getFields()[0];

        String chosenButton = gui.getUserButtonPressed(
                "Click a button",
                "Button 1", "Button 2"
        );
        String chosenElement = gui.getUserSelection(
                "Choose an element",
                "Element 1", "Element 2"
        );

    }
}