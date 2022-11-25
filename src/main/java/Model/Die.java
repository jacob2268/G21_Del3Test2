package Model;

public class Die {

    private final int maxValue = 6;
    private int faceValue;


    public Die() {
        faceValue = 1;
    }

    public int roll()
    {
        faceValue = (int)(Math.random() * maxValue) + 1;

        return faceValue;
    }
    public int getFaceValue() {
        return faceValue;
    }

    public String toString()
    {
        String result = Integer.toString(faceValue);

        return result;
    }

}
