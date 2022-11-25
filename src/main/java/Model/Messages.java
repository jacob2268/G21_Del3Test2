package Model;

public class Messages {



    public String StandingMessage(Player[] player) {
        String displayText = "Final standings:";
        int placeNum = 1;
        for (int i = player.length-1; i >= 0; i--) {
            String text ="\n" + placeNum + ": " + player[i].getName();
            displayText += text;
            placeNum = placeNum + 1;
        }
        return (displayText);
    }

//    public String VisitJail(Player player) {
//        return player.getName() + " lands on " + gui.getFields()[player.getPosition()].getTitle() + " and visits jail until your next turn";
//    }

    public String passingStart() {
        return "You passed start and received $2!";
    }

    public String startMessage(String playerName) {
        return playerName + " lands on Start and receives $" + 2;
    }
    public String chanceMessage(String playerName) {
        return playerName + " lands on chance and picks up a chance card";
    }
    public String visitJailMessage(String playerName) {
        return playerName + " lands on visit jail and visits jail until your next turn";
    }

    public String propertyMessage(String playerName) {
        return playerName + " lands on a property";
    }

    public String buyingMessage(int price) {
        return "This property is free to buy... so you buy it! You pay $" + price;
    }

    public String ownPropertyMessage() {

            return "This property is owned by yourself";
    }
    public String payRentMessage(int rent, String ownerName) {
        return "This property is owned. You pay $" + rent + " to " + ownerName;
    }

    public String landOnjailMessage(String playerName) {
        return playerName + " lands on jail.";
    }

    public String getOutOfJailMessage() {
        return "You have a Get Out Of Jail Free card! You do not pay the jail fee!";
    }

    public String payJailMessage() {
        return "You pay $1 to get out of jail next turn";
    }


    public String parkingMessage() {
        return "You park here until your next turn";
    }

    public String getForFree() {
        return "You get it for free!";
    }

    public String payDoubleRentMessage(String ownerName, int doubleRent) {
        return  ownerName + " owns this property and its neighbour. You pay double rent (" + doubleRent + ") to " + ownerName;
    }
}

