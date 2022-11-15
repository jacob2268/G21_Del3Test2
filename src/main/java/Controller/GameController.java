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

    private Board gameBoard;

    public GameController() {
        this.guiController = new GUIController();
    }



    public void playGame() {
        setupGame();
    }

    public void setupGame() {
        guiController.createBoard();
        setupPlayers();
        setupDice();
        setupPiece();

    }

    private void setupPiece() {

    }

    public DiceCup setupDice() {
        DiceCup diceCup = new DiceCup();

        return diceCup;
    }

    public Player[] setupPlayers(){
        int playerCount = guiController.getUserInteger();
        Player[] players = new Player[playerCount];

        for(int i = 0; i < playerCount; i++) {
            players[i] = new Player(guiController.getUserString(), 0, 20);
            guiController.addPlayer(players[i]);
            System.out.println("Element at index " + i + " : " + players[i].getName());
        }


        System.out.println("loop færdig");

        return players;
    }

}

