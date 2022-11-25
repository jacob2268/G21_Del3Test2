package Model;

import Controller.GUIController;
import Controller.GameController;

public class Constants {
    private CardDeck cardDeck;
    private Messages msg;
    private GUIController guiController;
//    GameController gameController;
    private Board gameBoard;
    private DiceCup diceCup;


    public Constants() {
        this.cardDeck = new CardDeck();
        this.msg = new Messages();
//        this.gameController = new GameController();
        this.guiController = new GUIController();
        this.gameBoard = new Board();
        this.diceCup = new DiceCup();
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(CardDeck cardDeck) {
        this.cardDeck = cardDeck;
    }

    public Messages getMsg() {
        return msg;
    }

    public void setMsg(Messages msg) {
        this.msg = msg;
    }

    public GUIController getGuiController() {
        return guiController;
    }

    public void setGuiController(GUIController guiController) {
        this.guiController = guiController;
    }

//    public GameController getGameController() {
//        return gameController;
//    }

//    public void setGameController(GameController gameController) {
//        this.gameController = gameController;
//    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public DiceCup getDiceCup() {
        return diceCup;
    }

    public void setDiceCup(DiceCup diceCup) {
        this.diceCup = diceCup;
    }
}
