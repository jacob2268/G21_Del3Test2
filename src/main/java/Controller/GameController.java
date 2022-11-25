package Controller;
import Model.*;
import Model.Fields.Field;
import Model.Fields.Property;
import Model.Player;
import Model.DiceCup;

public class GameController {
    GUIController guiController;
    private DiceCup diceCup = new DiceCup();

    private Board gameBoard = new Board();

    private Constants c = new Constants();
    private CardDeck cardDeck = new CardDeck();
    private ChanceCards[] cards;
    private Player[] players;
    private Field[] board;
    private Messages msg = new Messages();

    private boolean winnerIsFound = false;

    private static int currentPlayer;

    public GameController() {
        c.getGuiController();
    }

    public void playGame() {
        setupGame();
        while (!winnerIsFound) {
            playTurn();
            if (winnerIsFound) {
                displayStandings();
            }
        }
    }

    private void displayStandings() {
        Player[] sortedPlayers = playersSorted(players);
        c.getGuiController().showMessage(c.getMsg().StandingMessage(sortedPlayers));

    }


    private void playTurn() {
        for (currentPlayer = 0; currentPlayer < players.length; currentPlayer++) {
            c.getGuiController().showMessage1(players[currentPlayer]);
            c.getGuiController().rollDice(c);
            c.getGuiController().movePlayer(c,players[currentPlayer]);
            doAction(players[currentPlayer]);
            //checkForWinner(players[currentPlayer]);
            checkForWinner(players[currentPlayer]);
            if (winnerIsFound) return;

        }
    }

    private void checkForWinner(Player player) {
        if (player.getBalance() <= 0)
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
        board[player.getPosition()].doAction(c,player,this);
    }

    public void setupGame() {
        c.getGuiController().createGUIBoard();
        players = setupPlayers();
        c.getGuiController().setupPlayers(players);
        c.getGameBoard().createBoard();
        board = c.getGameBoard().createBoard();
        c.getCardDeck().createCardDeck();
        cards = c.getCardDeck().createCardDeck();

    }

    public Player[] setupPlayers() {
        int playerCount = c.getGuiController().getUserIntegerPlayerAmount();
        Player[] players = new Player[playerCount];

        for (int i = 0; i < playerCount; i++) {

            if (playerCount == 4) {
                players[i] = new Player(c.getGuiController().getUserStringPlayerNames(), 0, 4);
            } else if (playerCount == 3) {
                players[i] = new Player(c.getGuiController().getUserStringPlayerNames(), 0, 18);
            } else if (playerCount == 2) {
                players[i] = new Player(c.getGuiController().getUserStringPlayerNames(), 0, 20);
            }
        }

        return players;
    }

    public static int getCurrentPlayer() {
        return currentPlayer;
    }

    public Player[] playersSorted(Player[] players) {
        sortEndBalance(players);
        return players;
    }

    public void sortEndBalance(Player[] players) {
        int indexM = 0;
        do {
            indexM = 0;
            for (int i = 0; i < players.length - 1; i++) {
                if (players[i].getBalance() > players[i + 1].getBalance()) {
                    Player tempPlayer = players[i];
                    players[i] = players[i + 1];
                    players[i + 1] = tempPlayer;
                    indexM++;
                }
            }
        }
        while (indexM > 0);

    }
}


