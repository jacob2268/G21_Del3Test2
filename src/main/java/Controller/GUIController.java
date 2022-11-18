package Controller;

import Model.DiceCup;
import Model.Die;
import Model.FieldFactory;
import Model.Player;
import gui_fields.*;
import gui_main.GUI;


public class GUIController {

    private GUI_Field[] gui_fieldArray;
    private GUI gui;
    private GUI_Player[] gui_players;
    private DiceCup diceCup;
    private GUI_Car gui_car;
    private Player[] players;

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


    public void rollDice(DiceCup dicecup) {
        this.diceCup = new DiceCup();
        gui.setDice(dicecup.getFaceValueDie1(),dicecup.getFaceValueDie2());
    }

    public void showMessage1() {
        gui.showMessage("Klik OK for at kaste");
    }

    public void movePlayer(Player players) {
        this.gui_car = new GUI_Car();

        gui_car.setPosition(gui.getFields()[diceCup.getResult()]);

    }
}



