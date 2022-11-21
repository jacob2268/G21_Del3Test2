package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.ChanceCards;
import Model.Player;
import gui_fields.GUI_Player;

public class Jail extends Field {


    public Jail(String title, String subText) {
        super(title, subText);

    }

    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, ChanceCards chanceCards) {
        guiController.showJailMessage(player);
        player.subtractFromBalance(bonus);
        guiController.subtractFromGUIBalance(bonus,player);

    }

}
