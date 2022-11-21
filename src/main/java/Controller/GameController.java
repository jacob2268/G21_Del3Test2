package Controller;
import Model.Board;
import Model.ChanceCards;
import Model.Fields.Field;
import Model.Fields.Properties;
import Model.Player;
import Model.DiceCup;

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
            checkForWinner(players[currentPlayer]); // Spiller runden færdig, selvom nogen går bankerot. Skal rettes
//            if(players[currentPlayer].getBalance() < 0 || property.getOwner().getBalance() < 0) {
//                winnerIsFound = true;
//                break;
//            }
        }
    }

    private void checkForWinner(Player player) {
        if(player.getBalance() < 0)
            winnerIsFound = true;
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
}

