public class MonopolyGame {




    public static void setupGame() {
        createplayers();
    }

    public static void playGame() {

        while(!winnerIsFound) {
            playTurn();
        }

    }
}
