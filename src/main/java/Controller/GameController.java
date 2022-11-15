package Controller;
import Model.Board;
import Model.FieldFactory;
import gui_fields.GUI_Field;
import gui_main.GUI;
import Model.Player;
import Model.DiceCup;

import java.util.Arrays;

public class GameController {
    GUIController guiController;

    DiceCup diceCup;    

    private Board gameBoard;
    private Player[] players;

    public GameController() {
        this.guiController = new GUIController();
    }

    public void playGame() {
        setupGame();
        playTurn();
    }

    private void playTurn() {
        diceCup = new DiceCup();
        diceCup.roll();
        System.out.println(diceCup.getResult());
    }

    public void setupGame() {
        guiController.createBoard();
        players = setupPlayers();
        guiController.setupPlayers(players);

    }

    public Player[] setupPlayers(){
        int playerCount = guiController.getUserInteger();
        Player[] players = new Player[playerCount];

        for(int i = 0; i < playerCount; i++) {
            players[i] = new Player(guiController.getUserString(), 0, 20);
            System.out.println("Element at index " + i + " : " + players[i].getName());
        }
        return players;
    }

}

