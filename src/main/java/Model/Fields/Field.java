package Model.Fields;

import Model.Player;

public abstract class Field {

    String name;

    Field(String name) {
        this.name = name;
    }

    protected Field() {

    }

    public abstract void doAction(Player player);

    public String getName() {
        return name;
    }



}
