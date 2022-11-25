package Model;

import Controller.GUIController;
import Controller.GameController;

public class Constants {
    private CardDeck cardDeck;
    private Messages msg;
    private GUIController guiController;
    private Board gameBoard;
    private DiceCup diceCup;


    public Constants() {
        this.cardDeck = new CardDeck();
        this.msg = new Messages();
        this.guiController = new GUIController();
        this.gameBoard = new Board();
        this.diceCup = new DiceCup();
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }


    public Messages getMsg() {
        return msg;
    }


    public GUIController getGuiController() {
        return guiController;
    }



    public Board getGameBoard() {
        return gameBoard;
    }


    public DiceCup getDiceCup() {
        return diceCup;
    }

}
