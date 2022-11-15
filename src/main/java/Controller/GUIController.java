package Controller;

import Model.FieldFactory;
import Model.Player;
import gui_fields.*;
import gui_main.GUI;


public class GUIController {

    private GUI_Field[] gui_fieldArray;
    private GUI gui;
    private GUI_Player[] gui_players;

    public GUIController() {
        this.gui = new GUI(createBoard());
    }




    public GUI_Field[] createBoard() {
        FieldFactory fieldFactory = new FieldFactory();
        return fieldFactory.createBoard();
    }

    public int getUserInteger() {
        return gui.getUserInteger("Enter number of players (2-4)",2,4);
    }

    public String getUserString() {
        return gui.getUserString("Enter player" + " name");
    }

    public GUI_Player[] setupPlayers(Player[] players) {
        this.gui_players = new GUI_Player[players.length];
        for(int i = 0; i < players.length; i++) {
            gui_players[i] = new GUI_Player(players[i].getName(),players[i].getBalance());
            gui.addPlayer(gui_players[i]);
            gui.getFields()[0].setCar(gui_players[i],true);
        }
        return gui_players;
    }
}



