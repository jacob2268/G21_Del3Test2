package Test;

import Model.DiceCup;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceCupTest {

    @Test
    public void raffle() {
        int numberOfRolls = 1000;
        DiceCup diceCupTest = new DiceCup();
        double sum = 0;
        for (int i = 0; i < numberOfRolls; i++) {
            sum += diceCupTest.raffle();
        }
        double gennemsnit = sum / numberOfRolls;
        assertEquals(3.5, gennemsnit, 0.5);
    }
}