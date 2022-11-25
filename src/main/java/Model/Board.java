package Model;

import Model.Fields.*;

public class Board {
    private Field[] gameBoard;

    public Field[] createBoard() {
        gameBoard = new Field[]{
                new Start("Start", "You receive $2 when you land on or pass Start", 2),
                new Property("Burger Bar", "", false, null, 1, false, false),
                new Property("PizzaHut", "$1", false, null,1, false, false),
                new Chance("Chance", "Pick a chance card"),
                new Property("Candy Store", "$1", false, null, 1, false, false),
                new Property("Ice Cream Store", "$1", false, null, 1, false, false),
                new VisitJail("VisitJail", "You visit the jail"),
                new Property("Museum", "$2", false, null, 2, false, false),
                new Property("Library", "$2", false, null, 2, false, false),
                new Chance("Chance", "Pick a chance card"),
                new Property("Skate park", "$2", false, null, 2, false, false),
                new Property("Swimming Pool", "$2", false, null, 2, false, false),
                new Parking("Parking", "You park here until your next turn"),
                new Property("Arcade", "$3", false, null, 3, false, false),
                new Property("Cinema", "$3", false, null, 3, false, false),
                new Chance("Chance", "Pick a chance card"),
                new Property("Toy Store", "$3", false, null, 3, false, false),
                new Property("Pet Shop", "$3", false, null, 3, false, false),
                new Jail("Jail", "You go to jail"),
                new Property("Bowling Alley", "$4", false, null, 4, false, false),
                new Property("Zoo", "$4", false, null, 4, false, false),
                new Chance("Chance", "Pick a chance card"),
                new Property("Water Park", "$4", false, null, 4, false, false),
                new Property("Beach Walk", "$4", false, null, 4, false, false)
        };
        return gameBoard;
    }

    public String getTitle(int fieldIndex) {
        return gameBoard[fieldIndex].getTitle();
    }

    public String getSubText(int fieldIndex) {
        return gameBoard[fieldIndex].getSubText();
    }
//    public int getRent(Player player) {
//        return gameBoard[player.getPosIndex()].g;
//    }

    public Field getField(int fieldNumber) {
        return gameBoard[fieldNumber];
    }

    public Property getProperty(int fieldIndex) {
        return (Property) gameBoard[fieldIndex];
    }

    public Field getNextField(int fieldIndex) {
        return createBoard()[fieldIndex+1];
    }
    public Field getPreviousField(int fieldIndex) {
        return createBoard()[fieldIndex-1];
    }

    public Field[] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Field[] gameBoard) {
        this.gameBoard = gameBoard;
    }
}
