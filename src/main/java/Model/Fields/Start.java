package Model.Fields;

import Controller.GameController;
import Model.*;

public class  Start extends Field {
    private int bonus = 2;


    public Start(String title, String subText, int bonus) {
        super(title, subText);
        this.bonus = bonus;

    }

    @Override
    public void doAction(Constants c, Player player,GameController gameController) {
        c.getGuiController().showMessage(c.getMsg().startMessage(player.getName()));
        player.addToBalance(bonus);
        c.getGuiController().addToGUIBalance(bonus,player);

    }

}
