package Model;

import Model.Die;

public class DiceCup extends Die {

    Die die1 = new Die();
    Die die2 = new Die();
    private int result;

    public int raffle() {
        die1.roll();
        die2.roll();
        result = die1.getFaceValue() + die2.getFaceValue();
        return result;
    }
    public int getFaceValueDie1() {
        die1.roll();
        return die1.getFaceValue();
    }
    public int getFaceValueDie2() {
        die2.roll();
        return die2.getFaceValue();
    }

    public int getResult() {
        result = die1.getFaceValue() + die2.getFaceValue();
        return result;
    }
}
