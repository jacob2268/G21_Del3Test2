package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.Board;
import Model.CardDeck;
import Model.ChanceCards;
import Model.Player;

public class Start extends Field {
    private int bonus = 2;


    public Start(String title, String subText, int bonus) {
        super(title, subText);
        this.bonus = bonus;

    }

    // lige nu får man kun $2 når man lander på start og ikke når man passerer start
    @Override
    public void doAction(GUIController guiController, Player player, GameController gameController, CardDeck cardDeck, Board gameBoard) {
        guiController.showStartMessage(player);
        player.addToBalance(bonus);
        guiController.addToGUIBalance(bonus, player);

    }

    public int getBonus() {
        return bonus;
    }
}
