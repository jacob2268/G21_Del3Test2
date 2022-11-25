package Test;

import Model.CardDeck;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardDeckTest {

    @Test
    public void pickCard() {
        CardDeck cardDeckTest = new CardDeck();
        double numberOfCardsPicked = 1000;
        double sum = 0;
        for (int i = 0; i < numberOfCardsPicked; i++) {
            sum += cardDeckTest.pickCard();
        }
        double mean = sum/numberOfCardsPicked;
        assertEquals(7,mean,1);
    }
}