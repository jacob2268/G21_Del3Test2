package Model;

import Controller.GUIController;
import Controller.GameController;
import Model.Fields.Field;
import Model.Fields.Properties;
import gui_main.GUI;

import java.util.Random;

public class CardDeck {
    private ChanceCards currentCard;
//    = createCardDeck()[1];
    private String fieldsToMove;
    private int fieldToMoveTo;
    private String fieldNameToMoveTo;

    public ChanceCards[] createCardDeck() {
        return new ChanceCards[] {
                new ChanceCards("Move to start and receive the start bonus!",0),
                new ChanceCards("Move up to 5 fields forward!",1),
                new ChanceCards("Free property! Move to a orange colored property. If its unowned, you get it for free! " +
                        "If its owned, you pay rent to the owner",2), // fejl
                new ChanceCards("You either move 1 field forward or take another chance card!",3), // fejl
                new ChanceCards("You've eaten too much candy! Pay $2 to the bank.",4),
                new ChanceCards("Free property! Move to a orange colored property or an olive colored property. " +
                        "If its unowned, you get it for free! If its owned, you pay rent to the owner",5), // fejl
                new ChanceCards("Free property! Move to a purple colored property. If its unowned, you get it for free! " +
                        "If its owned, you pay rent to the owner",6), // fejl
                new ChanceCards("Get out of jail free! You keep this card until you need it",7), // fejl
                new ChanceCards("Move to The Beach Walk",8),
                new ChanceCards("Its your birthday! Everyone gives you $1. Happy birthday!",9), // fejl
                new ChanceCards("Free property! Move to a pink colored property or a light-blue colored property." +
                        "If its unowned, you get it for free! If its owned, you pay rent to the owner",10), // fejl
                new ChanceCards("You've done all your homework! Receive $2 from the bank",11),
                new ChanceCards("Free property! Move to a teal colored property. If its unowned, you get it for free! " +
                        "If its owned, you pay rent to the owner",12), // fejl
                new ChanceCards("Move to The Skate Park. If its unowned, you get it for free!" +
                        "If its owned, you pay rent to the owner",13), // fejl

        };
    }

    public int pickCard() {
        setCurrentCard(createCardDeck()[new Random().nextInt(createCardDeck().length)]);
        return currentCard.getNumber();
    }

    public void doCardAction(Player player, GUIController guiController, Board gameBoard, GameController gameController) {
        // pt får betaler man for ejendomme selv når man bør få dem gratis
        switch (currentCard.getNumber()) {
            case 0:
                guiController.movePlayerToField(player,0);
                gameController.doAction(player);
                break;
            case 1:
                fieldsToMove = guiController.getButtonPressedMoveForward();
                guiController.movePlayerChanceCard(player, gameBoard,Integer.parseInt(fieldsToMove));
                gameController.doAction(player);
                break;
            case 2:
                fieldNameToMoveTo = guiController.getButtonPressedMoveToGroup(gameBoard,gameBoard.createBoard()[1].getTitle(),gameBoard.createBoard()[2].getTitle());
                if(fieldNameToMoveTo  == gameBoard.createBoard()[1].getTitle())
                    fieldToMoveTo = 1;
                else
                    fieldToMoveTo = 2;
                guiController.movePlayerToField(player,fieldToMoveTo);
                break;
            case 3:
                String choice = guiController.getButtonPressedCardOrMove();
                if(choice == "Move 1 field forward")
                    guiController.movePlayerChanceCard(player,gameBoard,1);
                else
                    doCardAction(player,guiController,gameBoard,gameController);
                gameController.doAction(player);
                break;
            case 4:
                player.subtractFromBalance(2);
                guiController.subtractFromGUIBalance(2,player);
                break;
            case 5:
                fieldNameToMoveTo = guiController.getButtonPressedMoveToGroups(gameBoard,"Orange","Olive",
                        gameBoard.createBoard()[1].getTitle(),gameBoard.createBoard()[2].getTitle(),
                        gameBoard.createBoard()[19].getTitle(),gameBoard.createBoard()[20].getTitle());
                switch (fieldNameToMoveTo) {
                    case "Burger Bar":
                        fieldToMoveTo = 1;
                        break;
                    case "PizzaHut":
                        fieldToMoveTo = 2;
                        break;
                    case "Bowling Alley":
                        fieldToMoveTo = 19;
                        break;
                    case "Zoo":
                        fieldToMoveTo = 20;
                        break;
                }
                guiController.movePlayerToField(player,fieldToMoveTo);
                gameController.doAction(player);
                break;
            case 6:
                fieldNameToMoveTo = guiController.getButtonPressedMoveToGroup(gameBoard,gameBoard.createBoard()[4].getTitle(),gameBoard.createBoard()[5].getTitle());
                if(fieldNameToMoveTo  == gameBoard.createBoard()[4].getTitle())
                    fieldToMoveTo = 4;
                else
                    fieldToMoveTo = 5;
                guiController.movePlayerToField(player,fieldToMoveTo);
                gameController.doAction(player);
                break;
            case 7:
                player.setGetOutOfJail(true);
                break;
            case 8:
                guiController.movePlayerToField(player,23);
                gameController.doAction(player);
                break;
            case 9: // HOW???

                break;
            case 10:
                fieldNameToMoveTo = guiController.getButtonPressedMoveToGroups(gameBoard,"pink","light-blue",
                        gameBoard.createBoard()[7].getTitle(),gameBoard.createBoard()[8].getTitle(),
                        gameBoard.createBoard()[22].getTitle(),gameBoard.createBoard()[23].getTitle());
                switch (fieldNameToMoveTo) {
                    case "Museum":
                        fieldToMoveTo = 7;
                        break;
                    case "Library":
                        fieldToMoveTo = 8;
                        break;
                    case "Water Park":
                        fieldToMoveTo = 22;
                        break;
                    case "Beach Walk":
                        fieldToMoveTo = 23;
                        break;
                }
                guiController.movePlayerToField(player,fieldToMoveTo);
                gameController.doAction(player);
                break;
            case 11:
                player.addToBalance(2);
                guiController.subtractFromGUIBalance(2,player);
                break;
            case 12:
                fieldNameToMoveTo = guiController.getButtonPressedMoveToGroup(gameBoard,gameBoard.createBoard()[13].getTitle(),gameBoard.createBoard()[14].getTitle());
                if(fieldNameToMoveTo  == gameBoard.createBoard()[13].getTitle())
                    fieldToMoveTo = 13;
                else
                    fieldToMoveTo = 14;
                guiController.movePlayerToField(player,fieldToMoveTo);
                gameController.doAction(player);
                break;
            case 13:
                guiController.movePlayerToField(player,10);
                gameController.doAction(player);
                break;

        }
    }

    public int getCurrentCard() {
        return currentCard.getNumber();
    }

    public void setCurrentCard(ChanceCards currentCard) {
        this.currentCard = currentCard;
    }
}


