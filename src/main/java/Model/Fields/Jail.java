package Model.Fields;

import Controller.GameController;
import Model.*;

public class Jail extends Field {


    public Jail(String title, String subText) {
        super(title, subText);

    }

    @Override
    public void doAction(Constants c, Player player, GameController gameController) {
        c.getGuiController().showMessage(c.getMsg().landOnjailMessage(player.getName()));
        if (player.isGetOutOfJail()){
            c.getGuiController().showMessage(c.getMsg().getOutOfJailMessage());
            player.setGetOutOfJail(false);
        }
        else{
            c.getGuiController().showMessage(c.getMsg().payJailMessage());
            player.subtractFromBalance(1);
            c.getGuiController().subtractFromGUIBalance(1, player);
        }

    }

}
