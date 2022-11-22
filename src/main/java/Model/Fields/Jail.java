package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.Board;
import Model.CardDeck;
import Model.ChanceCards;
import Model.Player;

public class Jail extends Field {


    public Jail(String title, String subText) {
        super(title, subText);

    }

    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, CardDeck cardDeck, Board gameBoard) {
        guiController.showJailMessage(player);
        player.subtractFromBalance(1);
        guiController.subtractFromGUIBalance(1, player);
//        player.subtractFromBalance(bonus);
//        guiController.subtractFromGUIBalance(bonus,player);

    }

}
