package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.ChanceCards;
import Model.Player;
import gui_fields.GUI_Player;

public class Parking extends Field {
    public Parking(String title, String subText) {
        super(title, subText);
    }

    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, ChanceCards chanceCards) {
        guiController.showParkingMessage(player);
    }

}
