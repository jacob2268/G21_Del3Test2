package Model;

import Model.Die;

public class DiceCup extends Die {

    Die die1, die2 = new Die();
    private int result;

    public int roll() {
        die1.setFaceValue((int) (Math.random() * 6) + 1);
        die1.setFaceValue((int) (Math.random() * 6) + 1);
        result = die1.getFaceValue() + die2.getFaceValue();
        return result;
    }


}
