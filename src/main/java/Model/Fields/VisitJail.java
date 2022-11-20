package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.ChanceCards;
import Model.Player;
import gui_fields.GUI_Player;

public class VisitJail extends Field {
    public VisitJail(String title, String subText) {
        super(title, subText);
    }



    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, ChanceCards chanceCards) {
        guiController.showVisitJailMessage(player);

    }
}

