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
    public void doAction(Constants c, Player player,GameController gameController) {
//        guiController.showMessage(msg.VisitJail(player));
        c.getGuiController().showMessage(c.getMsg().visitJailMessage(player.getName()) );
       // player.subtractFromBalance()


    }
}

