package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.*;

public class VisitJail extends Field {

    private Messages msg = new Messages();

    private int jailfee = 1;


    public VisitJail(String title, String subText) {
        super(title, subText);
    }



    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, CardDeck cardDeck, Board gameBoard) {
//        guiController.showMessage(msg.VisitJail(player));
        guiController.showVisitJailMessage(player);
       // player.subtractFromBalance()


    }
}

