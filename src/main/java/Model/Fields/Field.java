package Model.Fields;

import Controller.GUIController;
import Controller.GameController;
import Model.Board;
import Model.CardDeck;
import Model.ChanceCards;
import Model.Player;

public abstract class Field {

    protected String title;
    protected String subText;



    public Field(String title, String subText) {
        this.title = title;
        this.subText = subText;

    }

    public String getTitle() {
        return title;
    }

    public String getSubText() {
        return subText;
    }

    public abstract void doAction(GUIController guiController, Player player, GameController gameController, CardDeck cardDeck, Board gameBoard);

//    public Player getOwner(Properties property) {
//        return property.getOwner();
//    }


}
