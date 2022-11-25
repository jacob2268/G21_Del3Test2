package Model.Fields;

import Controller.GameController;
import Model.Constants;
import Model.Player;
public class Parking extends Field {
    public Parking(String title, String subText) {
        super(title, subText);
    }

    @Override
    public void doAction(Constants c, Player player, GameController gameController) {
        c.getGuiController().showMessage(c.getMsg().parkingMessage());
    }

}
