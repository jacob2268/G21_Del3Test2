package Model.Fields;

import Controller.GameController;
import Model.*;
import com.thoughtworks.qdox.model.expression.Constant;

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

    public Object getSpecial(){
        return this;
    }

    //Medeater søg på google
    public abstract void doAction(Constants constants, Player player, GameController gameController);



}
