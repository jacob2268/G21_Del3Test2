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
}
