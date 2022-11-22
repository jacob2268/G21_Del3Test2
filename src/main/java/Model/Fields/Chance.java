package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.Board;
import Model.CardDeck;
import Model.ChanceCards;
import Model.Player;

public class Chance extends Field {

    public Chance(String title, String subText) {
        super(title, subText);
    }

    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, CardDeck cardDeck, Board gameBoard) {
        guiController.showChanceMessage(player);
        cardDeck.pickCard();
        guiController.displayChanceCard(cardDeck);
//        cardDeck.pickCard(player,guiController,gameBoard,gameController);
        cardDeck.doCardAction(player, guiController, gameBoard, gameController);

    }


}
