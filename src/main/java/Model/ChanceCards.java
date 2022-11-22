package Model;

public class ChanceCards {
    private String cardText;
    private int number;
    public ChanceCards(String cardText, int number) {
        this.cardText = cardText;
        this.number = number;
    }
    public String getCardText() {
        return cardText;
    }

    public int getNumber() {
        return number;
    }
}
