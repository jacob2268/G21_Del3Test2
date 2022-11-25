package Model.Fields;

import Controller.GameController;
import Model.*;

public class Chance extends Field {

    public Chance(String title, String subText) {
        super(title, subText);
    }

    @Override
    public void doAction(Constants c, Player player, GameController gameController) {
        c.getGuiController().showMessage(c.getMsg().chanceMessage(player.getName()));
        c.getCardDeck().pickCard();
        c.getGuiController().displayChanceCard(c.getCardDeck());
        c.getCardDeck().doCardAction(player,c,gameController);

    }


}
