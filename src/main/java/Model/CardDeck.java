package Model;

import Controller.GUIController;
import Controller.GameController;

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
                        "If its owned, you pay rent to the owner",2),
                new ChanceCards("You either move 1 field forward or take another chance card!",3),
                new ChanceCards("You've eaten too much candy! Pay $2 to the bank.",4),
                new ChanceCards("Free property! Move to a orange colored property or an olive colored property. " +
                        "If its unowned, you get it for free! If its owned, you pay rent to the owner",5),
                new ChanceCards("Free property! Move to a purple colored property. If its unowned, you get it for free! " +
                        "If its owned, you pay rent to the owner",6),
                new ChanceCards("Get out of jail free! You keep this card until you need it",7), // fejl
                new ChanceCards("Move to The Beach Walk",8),
                new ChanceCards("Its your birthday! Everyone gives you $1. Happy birthday!",9),
                new ChanceCards("Free property! Move to a pink colored property or a light-blue colored property." +
                        "If its unowned, you get it for free! If its owned, you pay rent to the owner",10),
                new ChanceCards("You've done all your homework! Receive $2 from the bank",11),
                new ChanceCards("Free property! Move to a teal colored property. If its unowned, you get it for free! " +
                        "If its owned, you pay rent to the owner",12),
                new ChanceCards("Move to The Skate Park. If its unowned, you get it for free!" +
                        "If its owned, you pay rent to the owner",13),

        };
    }

    public int pickCard() {
        setCurrentCard(createCardDeck()[new Random().nextInt(createCardDeck().length)]);
//        setCurrentCard(createCardDeck()[7]);

        return currentCard.getNumber();
    }


    public void doCardAction(Player player, Constants c, GameController gameController) {
        switch (currentCard.getNumber()) {
            case 0:
                c.getGuiController().movePlayerToField(player,0);
                gameController.doAction(player);
                break;
            case 1:
                fieldsToMove = c.getGuiController().getButtonPressedMoveForward();
                c.getGuiController().movePlayerChanceCard(player, c,Integer.parseInt(fieldsToMove));
                gameController.doAction(player);
                break;
            case 2:
                fieldNameToMoveTo = c.getGuiController().getButtonPressedMoveToGroup(c.getGameBoard().createBoard()[1].getTitle(),
                        c.getGameBoard().createBoard()[2].getTitle());
                if(fieldNameToMoveTo  == c.getGameBoard().createBoard()[1].getTitle())
                    fieldToMoveTo = 1;
                else
                    fieldToMoveTo = 2;
                player.setGetPropertyFree(true);
                c.getGuiController().movePlayerToField(player,fieldToMoveTo);
                gameController.doAction(player);
                break;
            case 3:
                String choice = c.getGuiController().getButtonPressedCardOrMove();
                if(choice == "Move 1 field forward") {
                    c.getGuiController().movePlayerChanceCard(player, c, 1);
                    gameController.doAction(player);
                }
                else {
                    pickCard();
                    doCardAction(player,c,gameController);
                }
                break;
            case 4:
                player.subtractFromBalance(2);
                c.getGuiController().subtractFromGUIBalance(2,player);
                break;
            case 5:
                fieldNameToMoveTo = c.getGuiController().getButtonPressedMoveToGroups("Orange","Olive",
                        c.getGameBoard().createBoard()[1].getTitle(),c.getGameBoard().createBoard()[2].getTitle(),
                        c.getGameBoard().createBoard()[19].getTitle(),c.getGameBoard().createBoard()[20].getTitle());
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
                player.setGetPropertyFree(true);
                c.getGuiController().movePlayerToField(player,fieldToMoveTo);
                gameController.doAction(player);
                break;
            case 6:
                fieldNameToMoveTo = c.getGuiController().getButtonPressedMoveToGroup(c.getGameBoard().createBoard()[4].getTitle(),c.getGameBoard().createBoard()[5].getTitle());
                if(fieldNameToMoveTo  == c.getGameBoard().createBoard()[4].getTitle())
                    fieldToMoveTo = 4;
                else
                    fieldToMoveTo = 5;
                player.setGetPropertyFree(true);
                c.getGuiController().movePlayerToField(player,fieldToMoveTo);
                gameController.doAction(player);
                break;
            case 7:
                player.setGetOutOfJail(true);
                break;
            case 8:
                c.getGuiController().movePlayerToField(player,23);
                gameController.doAction(player);
                break;
            case 9:
                for(int i = 0; i < gameController.getPlayers().length;i++){
                    gameController.getPlayers()[i].subtractFromBalance(1);
                    c.getGuiController().subtractFromGUIBalance(1,gameController.getPlayers()[i]);
                }
                player.addToBalance(gameController.getPlayerCount());
                c.getGuiController().addToGUIBalance(gameController.getPlayerCount(),player);
                break;
            case 10:
                fieldNameToMoveTo = c.getGuiController().getButtonPressedMoveToGroups("pink","light-blue",
                        c.getGameBoard().createBoard()[7].getTitle(),c.getGameBoard().createBoard()[8].getTitle(),
                        c.getGameBoard().createBoard()[22].getTitle(),c.getGameBoard().createBoard()[23].getTitle());
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
                player.setGetPropertyFree(true);
                c.getGuiController().movePlayerToField(player,fieldToMoveTo);
                gameController.doAction(player);
                break;
            case 11:
                player.addToBalance(2);
                c.getGuiController().subtractFromGUIBalance(2,player);
                break;
            case 12:
                fieldNameToMoveTo = c.getGuiController().getButtonPressedMoveToGroup(c.getGameBoard().createBoard()[13].getTitle(),c.getGameBoard().createBoard()[14].getTitle());
                if(fieldNameToMoveTo  == c.getGameBoard().createBoard()[13].getTitle())
                    fieldToMoveTo = 13;
                else
                    fieldToMoveTo = 14;
                player.setGetPropertyFree(true);
                c.getGuiController().movePlayerToField(player,fieldToMoveTo);
                gameController.doAction(player);
                break;
            case 13:
                player.setGetPropertyFree(true);
                c.getGuiController().movePlayerToField(player,10);
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


