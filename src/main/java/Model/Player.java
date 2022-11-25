package Model;

import Controller.GUIController;
import Model.Fields.Field;
import Model.Fields.Property;
import gui_fields.GUI_Player;

public class Player {

    private String name;
    private int balance;

    private int position;
    private GUI_Player gui_player;
    private boolean getOutOfJail = false;
    private boolean getPropertyFree = false;

    private Field field;

    public Player(String name, int position, int balance) {
        this.name = name;
        this.position = position;
        this.balance = balance;


    }

    public String getName() {
        return name;
    }



    public int getBalance() {
        return balance;
    }

    public GUI_Player getGui_player() {
        return gui_player;
    }

    public void setGui_player(GUI_Player gui_player) {

        this.gui_player = gui_player;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int addToBalance(int value) {
        return balance = balance + value;
    }
    public int subtractFromBalance(int value) {
        return balance = balance - value;
    }

    public void payRent(int value, Player player, Property property) {
        Player receiver = property.getOwner();
        player.subtractFromBalance(value);
        receiver.addToBalance(value);
    }
    public void payDoubleRent(int value, Player player, Property property) {
        Player receiver = property.getOwner();
        player.subtractFromBalance(value*2);
        receiver.addToBalance(value*2);
    }

    public void receivePassingStartBonus(Player player, GUIController guiController) {
        player.addToBalance(2);
        guiController.addToGUIBalance(2,player);
    }

    public boolean isGetOutOfJail() {
        return getOutOfJail;
    }

    public void setGetOutOfJail(boolean getOutOfJail) {
        this.getOutOfJail = getOutOfJail;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public boolean isGetPropertyFree() {
        return getPropertyFree;
    }

    public void setGetPropertyFree(boolean getPropertyFree) {
        this.getPropertyFree = getPropertyFree;
    }
}

