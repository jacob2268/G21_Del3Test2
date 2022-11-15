package Model;

public class Die {

    private final int maxValue = 6;
    private int faceValue;

    public Die() {
        faceValue = 1;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int value){
        faceValue = value;
    }

    public String toString()
    {
        String result = Integer.toString(faceValue);

        return result;
    }

}
