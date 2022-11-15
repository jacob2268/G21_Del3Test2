package Model;

public class Player {

    private String name;
    private int position;
    private int balance;

    public Player(String name, int position, int balance) {
        this.name = name;
        this.position = position;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getBalance() {
        return balance;
    }
}
