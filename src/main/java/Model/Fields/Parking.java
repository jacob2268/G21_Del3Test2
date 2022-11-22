package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.Board;
import Model.CardDeck;
import Model.ChanceCards;
import Model.Player;

public class Parking extends Field {
    public Parking(String title, String subText) {
        super(title, subText);
    }

    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, CardDeck cardDeck, Board gameBoard) {
        guiController.showParkingMessage(player);
    }

}
