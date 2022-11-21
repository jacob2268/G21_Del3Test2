package Controller;

import Model.*;
import Model.Fields.Properties;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;


public class GUIController {

    private GUI_Field[] gui_fieldArray;
    private GUI gui;
    private GUI_Player[] gui_players;
    private DiceCup diceCup;
    private Color[] carColors = {Color.red, Color.BLUE, Color.YELLOW, Color.GREEN};
    private int GUIPlayerBalance;




    public GUIController() {
        this.gui = new GUI(createGUIBoard());
    }

    public GUI_Field[] createGUIBoard() {
        GUIFieldFactory guiFieldFactory = new GUIFieldFactory();
        return guiFieldFactory.createBoard();
    }

    public void makePropertyOwnable() {
    }

    public int getUserInteger() {
        return gui.getUserInteger("Enter number of players (2-4)",2,4);
    }

    public String getUserString() {
        return gui.getUserString("Enter player" + " name");
    }

    public GUI_Player[] setupPlayers(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            player.setGui_player(new GUI_Player(player.getName(), player.getBalance()));
            gui.addPlayer(player.getGui_player());
            gui_players = new GUI_Player[players.length];
            gui_players[i] = player.getGui_player();
            player.getGui_player().getCar().setPrimaryColor(carColors[i]);
            player.setPosition(0);
            player.getGui_player().getCar().setPosition(gui.getFields()[0]);
        }
        return gui_players;
    }
    public void rollDice(DiceCup dicecup) {
        this.diceCup = new DiceCup();
        gui.setDice(dicecup.getFaceValueDie1(),dicecup.getFaceValueDie2());
    }

    public void showMessage1(Player player) {
        gui.showMessage("Click OK for " + player.getName() + " to throw the dice");
    }

    public void movePlayer(Player player, DiceCup diceCup, Board gameBoard) {

        player.setPosition(player.getPosition() + diceCup.getResult());
        if(player.getPosition() >= createGUIBoard().length) {
            player.setPosition((player.getPosition()) % createGUIBoard().length);
            if(player.getPosition() == 0){
                player.getGui_player().getCar().setPosition(this.gui.getFields()[player.getPosition()]);
                gui.getFields()[player.getPosition()].setTitle(gameBoard.getTitle(player));
            } else {
                player.receivePassingStartBonus(player,this);
                player.getGui_player().getCar().setPosition(this.gui.getFields()[player.getPosition()]);
                gui.getFields()[player.getPosition()].setTitle(gameBoard.getTitle(player));
                showPassingStartMessage();
            }
        }else {
            gui.getFields()[player.getPosition()].setTitle(gameBoard.getTitle(player));
            player.getGui_player().getCar().setPosition(this.gui.getFields()[player.getPosition()]);
        }
    }

    public int getGUIBalance(Player player) {
        GUIPlayerBalance = player.getBalance();
        return GUIPlayerBalance;
    }

    public void addToGUIBalance(int value, Player player) {
        player.getGui_player().setBalance(player.getGui_player().getBalance() + value);

    }
    public void subtractFromGUIBalance(int value, Player player) {
        player.getGui_player().setBalance(player.getGui_player().getBalance() - value);
    }
    public String getGUITitle(Player player) {
        return gui.getFields()[player.getPosition()].getTitle();
    }
    public String getGUISubText(Player player) {
        return gui.getFields()[player.getPosition()].getSubText();
    }
    public String getGUIDescription(Player player) {
        return gui.getFields()[player.getPosition()].getDescription();
    }

    public void showParkingMessage(Player player) {
        gui.showMessage(player.getName() + " lands on " + gui.getFields()[player.getPosition()].getTitle() + " and parks here until your next turn");
    }

    public void showVisitJailMessage(Player player) {
        gui.showMessage(player.getName() + " lands on " + gui.getFields()[player.getPosition()].getTitle() + " and visits jail until your next turn");
    }
    public void showChanceMessage(Player player) {
        gui.showMessage(player.getName() + " lands on " + gui.getFields()[player.getPosition()].getTitle() + " and picks up a chance card");
    }
    public void showJailMessage(Player player) {
        gui.showMessage(player.getName() + " lands on " + gui.getFields()[player.getPosition()].getTitle() + " and goes to jail");
    }
    public void showPropertiesMessage(Player player) {
        gui.showMessage(player.getName() + " lands on " + gui.getFields()[player.getPosition()].getTitle());
    }
    public void showStartMessage(Player player) {
        gui.showMessage(player.getName() + " lands on " + gui.getFields()[player.getPosition()].getTitle() + " and receives $" + 2);
    }

    public void showBuyingMessage() {
        gui.showMessage("This property is free to buy... so you buy it! You pay ");
    }
    public void showPassingStartMessage() {
        gui.showMessage("You passed start and received $2!");
    }

    public void updateFieldStatus(Player player) {
        ((GUI_Ownable) gui.getFields()[player.getPosition()]).setOwnerName(player.getName());
    }

    public void showRentMessage(Player player) {
        if(Objects.equals(player.getName(), ((GUI_Ownable) gui.getFields()[player.getPosition()]).getOwnerName())){
            gui.showMessage("This property is owned ny yourself");
        }else
            gui.showMessage("This property is owned. You pay " + gui.getFields()[player.getPosition()].getSubText() + " to " + ((GUI_Ownable) gui.getFields()[player.getPosition()]).getOwnerName());

    }
    public String getOwnerName(Player player) {
        return ((GUI_Ownable) gui.getFields()[player.getPosition()]).getOwnerName();
    }

    public Color getColor(Player player){
        return player.getGui_player().getPrimaryColor();
    }
    public void setBorderColor(Player player) {
        ((GUI_Ownable) gui.getFields()[player.getPosition()]).setBorder(getColor(player));
    }

    public void displayStandings(Player player) {
        gui.showMessage("The game is over because " + player.getName() + " is bankrupt");
        int[] standings  = new int[gui_players.length];

        for(int i = 0; i < gui_players.length; i++)
            standings[i] = gui_players[i].getBalance();
        Arrays.sort(standings);
        System.out.println(standings);
    }

    public void displayChanceCard(ChanceCards chanceCards) {
        gui.displayChanceCard("TEST CHANCE CARD");
    }

    public GUI_Player[] getGui_players() {
        return gui_players;
    }

    public void payRent(int value, Player player, Properties property) {
        subtractFromGUIBalance(value,player);
        addToGUIBalance(value,property.getOwner());

    }
}



