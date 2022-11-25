package Controller;

import Model.*;
import Model.Fields.Property;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.util.Objects;


public class GUIController {

    private GUI_Field[] gui_fieldArray;
    private GUI gui;
    private GUI_Player[] gui_players;
    private Color[] carColors = {Color.red, Color.BLUE, Color.YELLOW, Color.GREEN};
    private int GUIPlayerBalance;



    public GUIController() {
        this.gui = new GUI(createGUIBoard());
    }

    public GUI_Field[] createGUIBoard() {
        GUIFieldFactory guiFieldFactory = new GUIFieldFactory();
        return guiFieldFactory.createBoard();
    }


    public int getUserIntegerPlayerAmount() {
        return gui.getUserInteger("Enter number of players (2-4)",2,4);
    }

    public String getUserStringPlayerNames() {
        return gui.getUserString("Enter player" + " name");
    }

    public String getButtonPressedMoveForward() {
        return gui.getUserButtonPressed("How many fields do you want to move forward?", "1", "2", "3", "4", "5");
    }
    public String getButtonPressedMoveToGroup(String option1, String option2) {
        return gui.getUserButtonPressed("What property do you want to move to?", option1,option2);
    }
    public String getButtonPressedMoveToGroups(String color1, String color2, String option1, String option2, String option3, String option4) {
        String color = gui.getUserButtonPressed("What color of properties would you like to go to?", color1,color2);
        String choice;
        if(color == color1)
            choice = gui.getUserButtonPressed("What property do you want to move to?", option1,option2);
        else
            choice = gui.getUserButtonPressed("What property do you want to move to?", option3,option4);
        return choice;
    }
    public String getButtonPressedCardOrMove() {
        return gui.getUserButtonPressed("What would you like to do?", "Move 1 field forward", "Pick up another chance card");
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
    public void rollDice(Constants c) {
        gui.setDie(c.getDiceCup().getFaceValueDie1());
    }

    public void showMessage1(Player player) {
        gui.showMessage("Click OK for " + player.getName() + " to throw the dice");
    }

    public void movePlayerToField(Player player, int fieldToMoveTo) { // man modtager pt ikke startbonus hvis man bevæger sig til et specifikt felt som følge af et chancekort
        player.setPosition(fieldToMoveTo);
        player.getGui_player().getCar().setPosition(this.gui.getFields()[player.getPosition()]);
    }
    public void movePlayerChanceCard(Player player, Constants c, int fieldsToMove) {
        player.setPosition(player.getPosition() + fieldsToMove);
        player.setField(c.getGameBoard().getGameBoard()[player.getPosition()]);
        if(player.getPosition() >= createGUIBoard().length) {
            player.setPosition((player.getPosition()) % createGUIBoard().length);
            if(player.getPosition() == 0){
                player.getGui_player().getCar().setPosition(this.gui.getFields()[player.getPosition()]);
                gui.getFields()[player.getPosition()].setTitle(c.getGameBoard().getTitle(player));
            } else {
                player.receivePassingStartBonus(player,this);
                player.getGui_player().getCar().setPosition(this.gui.getFields()[player.getPosition()]);
                gui.getFields()[player.getPosition()].setTitle(c.getGameBoard().getTitle(player));
                showMessage(c.getMsg().passingStart());
            }
        }else {
            gui.getFields()[player.getPosition()].setTitle(c.getGameBoard().getTitle(player));
            player.getGui_player().getCar().setPosition(this.gui.getFields()[player.getPosition()]);
        }
    }

    public void movePlayer(Constants c, Player player) {

        player.setPosition(player.getPosition() + c.getDiceCup().getResult());
        if(player.getPosition() >= createGUIBoard().length) {
            player.setPosition((player.getPosition()) % createGUIBoard().length);
            if(player.getPosition() == 0){
                player.getGui_player().getCar().setPosition(this.gui.getFields()[player.getPosition()]);
                gui.getFields()[player.getPosition()].setTitle(c.getGameBoard().getTitle(player));
            } else {
                player.receivePassingStartBonus(player,this);
                player.getGui_player().getCar().setPosition(this.gui.getFields()[player.getPosition()]);
                gui.getFields()[player.getPosition()].setTitle(c.getGameBoard().getTitle(player));
                showMessage(c.getMsg().passingStart());
            }
        }else {
            gui.getFields()[player.getPosition()].setTitle(c.getGameBoard().getTitle(player));
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


    public void showMessage(String message) {
        gui.showMessage(message);
    }



    public void showPropertiesMessage(Player player) {
        gui.showMessage(player.getName() + " lands on " + gui.getFields()[player.getPosition()].getTitle());
    }


    public void updateFieldStatus(Player player) {
        ((GUI_Ownable) gui.getFields()[player.getPosition()]).setOwnerName(player.getName());
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


    public void displayChanceCard(CardDeck cardDeck) {
        gui.displayChanceCard(cardDeck.createCardDeck()[cardDeck.getCurrentCard()].getCardText());
    }

    public GUI_Player[] getGui_players() {
        return gui_players;
    }

    public void payRent(int value, Player player, Property property) {
        subtractFromGUIBalance(value,player);
        addToGUIBalance(value,property.getOwner());

//


    }
    public void payDoubleRent(int value, Player player, Property property) {
        subtractFromGUIBalance(value*2,player);
        addToGUIBalance(value*2,property.getOwner());

    }

    public void showPayJailMessage() {
        gui.showMessage("You pay $1 to get out of jail :(");
    }


}



