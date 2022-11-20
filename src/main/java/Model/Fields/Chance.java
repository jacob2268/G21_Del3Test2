package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.ChanceCards;
import Model.Player;

public class Chance extends Field {

    public Chance(String title, String subText) {
        super(title, subText);
    }

    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, ChanceCards chanceCards) {
        guiController.showChanceMessage(player);
    }


}
