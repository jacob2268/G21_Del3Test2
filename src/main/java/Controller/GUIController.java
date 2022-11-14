package Controller;

import Model.FieldFactory;
import gui_fields.*;
import gui_main.GUI;
import org.jetbrains.annotations.NotNull;


import java.awt.*;
import java.lang.reflect.Field;


public class GUIController {

    GUI_Field[] gui_fieldArray;
    static GUI gui;
    GUI_Player[] gui_players;








    public void createBoard() {
        FieldFactory fieldFactory = new FieldFactory();
        fieldFactory.createBoard();
    }


    private static void setupPlayers() {
        String chosenElement = gui.getUserSelection(
                "Select the number of players and press OK",
                "1", "2", "3", "4"
        );
        switch (chosenElement) {
            case "1":
                @NotNull String input1 = gui.getUserString("Enter the name of player 1 and press OK");
                //@NotNull String ageP1 = gui.getUserString("Enter the age of player 1 and press OK");
                GUI_Player player1 = new GUI_Player(input1, 20);
                gui.addPlayer(player1);
                player1.getCar().setPosition(field);
                Account accountP1 = new Account(player1);
                gui.showMessage(" ");
                break;
            case "2":
                @NotNull String nameP1 = gui.getUserString("Enter the name of player 1 and press OK");
                player1 = new GUI_Player(nameP1, 20);
                gui.addPlayer(player1);
                player1.getCar().setPosition(field);
                accountP1 = new Account(player1);
                @NotNull String input2 = gui.getUserString("Enter the name of player 2 and press OK");
                GUI_Player player2 = new GUI_Player(input2, 20);
                gui.addPlayer(player2);
                player2.getCar().setPosition(field);
                Account accountP2 = new Account(player2);
                gui.showMessage(" ");
                break;
            case "3":
                input1 = gui.getUserString("Enter the name of player 1 and press OK");
                player1 = new GUI_Player(input1, 18);
                gui.addPlayer(player1);
                player1.getCar().setPosition(field);
                accountP1 = new Account(player1);
                input2 = gui.getUserString("Enter the name of player 2 and press OK");
                player2 = new GUI_Player(input2, 18);
                gui.addPlayer(player2);
                player2.getCar().setPosition(field);
                accountP2 = new Account(player2);
                @NotNull String input3 = gui.getUserString("Enter the name of player 3 and press OK");
                GUI_Player player3 = new GUI_Player(input3, 18);
                gui.addPlayer(player3);
                player3.getCar().setPosition(field);
                Account accountP3 = new Account(player3);
                gui.showMessage(" ");
                break;
            case "4":
                input1 = gui.getUserString("Enter the name of player 1 and press OK");
                player1 = new GUI_Player(input1, 16);
                gui.addPlayer(player1);
                player1.getCar().setPosition(field);
                accountP1 = new Account(player1);
                input2 = gui.getUserString("Enter the name of player 2 and press OK");
                player2 = new GUI_Player(input2, 16);
                gui.addPlayer(player2);
                player2.getCar().setPosition(field);
                accountP2 = new Account(player2);
                input3 = gui.getUserString("Enter the name of player 3 and press OK");
                player3 = new GUI_Player(input3, 16);
                gui.addPlayer(player3);
                player3.getCar().setPosition(field);
                accountP3 = new Account(player3);
                @NotNull String input4 = gui.getUserString("Enter the name of player 4 and press OK");
                GUI_Player player4 = new GUI_Player(input4, 16);
                gui.addPlayer(player4);
                player4.getCar().setPosition(field);
                Account accountP4 = new Account(player4);
                gui.showMessage(" ");
                break;
        }
    }
}

