package Controller;
import Model.Board;
import Model.ChanceCards;
import Model.Fields.Field;
import Model.Fields.Properties;
import Model.Player;
import Model.DiceCup;

import java.util.ArrayList;
import java.util.Arrays;

public class GameController {
    GUIController guiController;

    private DiceCup diceCup = new DiceCup();

    private Board gameBoard = new Board();
    private Player[] players;
    private Field[] board;
    private ChanceCards chanceCards;
    private boolean winnerIsFound = false;

    private static int currentPlayer;

    public GameController() {
        this.guiController = new GUIController();
    }

    public void playGame() {
        setupGame();
        while(!winnerIsFound) {
            playTurn();
        }
        displayStandings();

    }

    private void displayStandings() {
        //skal laves en metode for at vise stillingen, når en er gået bankerot
        // guiController.displayStandings(players[currentPlayer]);
    }


    private void playTurn() {
        for (currentPlayer = 0; currentPlayer < players.length; currentPlayer++) {
            guiController.showMessage1(players[currentPlayer]);
            guiController.rollDice(diceCup);
            guiController.movePlayer(players[currentPlayer], diceCup, gameBoard);
            doAction(players[currentPlayer]);
            //checkForWinner(players[currentPlayer]);
            checkForWinner(players);
            if (winnerIsFound) return;

        }
    }

    private void checkForWinner(Player player) {
        if(player.getBalance() <= 0)
            winnerIsFound = true;



    }

    Player losingPlayer;

    private void checkForWinner (Player[] players){
        for (Player player:players) {
            if(player.getBalance() <= 0)
             //   winnerIsFound = true;
                losingPlayer = player;
            // der mangler et sted hvor at man definere en losing player
        }
    }


    private void doAction(Player player) {
        board[player.getPosition()].doAction(guiController, players[currentPlayer],this,chanceCards);
    }

    public void setupGame() {
        guiController.createGUIBoard();
        players = setupPlayers();
        guiController.setupPlayers(players);
        gameBoard.createBoard();
        board = gameBoard.createBoard();
    }

    public Player[] setupPlayers(){
        int playerCount = guiController.getUserInteger();
        Player[] players = new Player[playerCount];

        for (int i = 0; i < playerCount; i++) {

            if(playerCount == 4) {
                players[i] = new Player(guiController.getUserString(), 0, 16);
            }
            else if(playerCount == 3) {players[i] = new Player(guiController.getUserString(), 0, 18);
            }
            else if(playerCount == 2) {
                players[i] = new Player(guiController.getUserString(), 0, 20);
            }
        }

        return players;
    }

    public static int getCurrentPlayer() {
        return currentPlayer;
    }

    public void sortedEndBalance (Player[] players) {
        Player temp = null;

        for (int i = 0; i < players.length; i++) {

            for (int j = 1; j < (players.length - i); j++) {
                if (players[j - 1].getBalance() > players[j].getBalance()) {
                    temp = players[j - 1];
                    players[i] = players[j];
                    players[j] = temp;

                }
            }
        }

    }
}

// tag spiller array, for hvert index tjekke balancen, også sortere ud fra den balance , lav et loop som checker hvilken spiller har mindst/flest penge
// hav 2 array


