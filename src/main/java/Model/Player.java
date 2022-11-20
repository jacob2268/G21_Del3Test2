package Model;

import Model.Fields.Properties;
import gui_fields.GUI_Player;

public class Player {

    private String name;
    private int balance;

    private int position;
    private GUI_Player gui_player;
    private boolean getOutOfJail = false;

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

    public void payRent(int value, Player player, Properties property) {
        Player receiver = property.getOwner();
        player.subtractFromBalance(value);
        receiver.addToBalance(value);
    }
//
//    public Player getPlayer(GUIController guiController, Player player) {
//        Player owner = (Player) guiController.getOwnerName(player);
//        return owner;
//    }

    public void recieveStartBonus(Player player) {
        player.addToBalance(2);
    }
}

