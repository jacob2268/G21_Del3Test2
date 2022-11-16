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

    private DiceCup diceCup = new DiceCup();

    private Board gameBoard;
    private Player[] players;
    private boolean winnerIsFound = false;

    public GameController() {
        this.guiController = new GUIController();
    }

    public void playGame() {
        setupGame();
        while(!winnerIsFound) {
            playTurn();
        }

    }

    private void playTurn() {
        for (int i = 0; i < players.length; i++) {
            guiController.showMessage1();
            guiController.rollDice(diceCup);
            System.out.println(players[i].getName() + "'s turn. " + players[i].getName() + " throws " + diceCup.getResult());
            guiController.movePlayer(players[i]);
        }
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

