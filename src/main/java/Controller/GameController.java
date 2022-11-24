package Controller;
import Model.*;
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

    private CardDeck cardDeck = new CardDeck();
    private ChanceCards[] cards;
    private Player[] players;
    private Field[] board;
    private Properties property;
    private boolean winnerIsFound = false;

    private static int currentPlayer;

    public GameController() {
        this.guiController = new GUIController();
    }

    public void playGame() {
        setupGame();
        while(!winnerIsFound) {
            playTurn();
if (winnerIsFound) {
    displayStandings();
}
        }
    }

    private void displayStandings() {
       Player[] sortedPlayers = playersSorted(players);
        guiController.showStandingMessage(sortedPlayers);

    }


    private void playTurn() {
        for (currentPlayer = 0; currentPlayer < players.length; currentPlayer++) {
            guiController.showMessage1(players[currentPlayer]);
            guiController.rollDice(diceCup);
            guiController.movePlayer(players[currentPlayer], diceCup, gameBoard);
            doAction(players[currentPlayer]);
            //checkForWinner(players[currentPlayer]);
            checkForWinner(players[currentPlayer]);
            if (winnerIsFound) return;

        }
    }

    private void checkForWinner(Player player) {
        if(player.getBalance() <= 0)
            winnerIsFound = true;
    }

//    Player losingPlayer;
//
//    private void checkForWinner (Player[] players){
//        for (Player player:players) {
//            if(player.getBalance() <= 0)
//             //   winnerIsFound = true;
//                losingPlayer = player;
//            // der mangler et sted hvor at man definere en losing player
//        }
//    }


    public void doAction(Player player) {
        board[player.getPosition()].doAction(guiController, players[currentPlayer],this, cardDeck, gameBoard);
    }

    public void setupGame() {
        guiController.createGUIBoard();
        players = setupPlayers();
        guiController.setupPlayers(players);
        gameBoard.createBoard();
        board = gameBoard.createBoard();
        cardDeck.createCardDeck();
        cards = cardDeck.createCardDeck();

    }

    public Player[] setupPlayers(){
        int playerCount = guiController.getUserIntegerPlayerAmount();
        Player[] players = new Player[playerCount];

        for (int i = 0; i < playerCount; i++) {

            if(playerCount == 4) {
                players[i] = new Player(guiController.getUserStringPlayerNames(), 0, 4);
            }
            else if(playerCount == 3) {players[i] = new Player(guiController.getUserStringPlayerNames(), 0, 18);
            }
            else if(playerCount == 2) {
                players[i] = new Player(guiController.getUserStringPlayerNames(), 0, 20);
            }
        }

        return players;
    }

    public static int getCurrentPlayer() {
        return currentPlayer;
    }

    public Player[] playersSorted(Player[] players){
        sortEndBalance(players);
        return players;
    }

    public void sortEndBalance (Player[] players) {
        int indexM = 0;
        do {
            indexM = 0;
            for (int i = 0; i < players.length-1; i++) {
                if (players[i].getBalance() > players[i+1].getBalance()){
                    Player tempPlayer = players[i];
                    players[i] = players[i+1];
                    players[i+1] = tempPlayer;
                    indexM++;
                }
            }
        }
        while (indexM > 0);

        }



        /*
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
return players;
    }
}

// tag spiller array, for hvert index tjekke balancen, også sortere ud fra den balance, lav et loop som checker hvilken spiller har mindst/flest penge
// hav 2 array


