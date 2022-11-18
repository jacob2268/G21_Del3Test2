package Model;

import gui_fields.GUI_Player;

public class Player {

    private String name;
    private int position;
    private int balance;

    private int posIndex;
    private GUI_Player gui_player;

    public Player(String name, int position, int balance) {
        this.name = name;
        this.position = position;
        this.balance = balance;

    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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

    public int getPosIndex() {
        return posIndex;
    }

    public void setPosIndex(int posIndex) {
        this.posIndex = posIndex;
    }
}
