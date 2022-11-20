package Model;

import Model.Fields.*;

public class Board {
    private Field[] gameBoard;

    public Field[] createBoard() {
        gameBoard = new Field[]{
                new Start("Start", "You recieve $2 when you land on or pass Start", 2),
                new Properties("Burger Bar", "", false, null, 1),
                new Properties("PizzaHut", "$1", false, null,1),
                new Chance("Chance", "Pick a chance card"),
                new Properties("Candy Store", "$1", false, null, 1),
                new Properties("Ice Cream Store", "$1", false, null, 1),
                new VisitJail("VisitJail", "You visit the jail"),
                new Properties("Museum", "$2", false, null, 2),
                new Properties("Library", "$2", false, null, 2),
                new Chance("Chance", "Pick a chance card"),
                new Properties("Skate park", "$2", false, null, 2),
                new Properties("Swimming Pool", "$2", false, null, 2),
                new Parking("Parking", "You park here until your next turn"),
                new Properties("Arcade", "$3", false, null, 3),
                new Properties("Cinema", "$3", false, null, 3),
                new Chance("Chance", "Pick a chance card"),
                new Properties("Toy Store", "$3", false, null, 3),
                new Properties("Pet Shop", "$3", false, null, 3),
                new Jail("Jail", "You go to jail"),
                new Properties("Bowling Alley", "$4", false, null, 4),
                new Properties("Zoo", "$4", false, null, 4),
                new Chance("Chance", "Pick a chance card"),
                new Properties("Water Park", "$4", false, null, 4),
                new Properties("Beach Walk", "$4", false, null, 4)
        };
        return gameBoard;
    }

    public String getTitle(Player player) {
        return gameBoard[player.getPosition()].getTitle();
    }

    public String getSubText(Player player) {
        return gameBoard[player.getPosition()].getSubText();
    }
//    public int getRent(Player player) {
//        return gameBoard[player.getPosIndex()].g;
//    }

    public Player getOwner(Player player) {
        return gameBoard[player.getPosition()].getOwner((Properties) gameBoard[player.getPosition()]);
    }

}
