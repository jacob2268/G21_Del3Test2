package Test;

import Model.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void addToBalance() {
        Player player = new Player("Test", 2,10);
        double addMoney = 10.0;
        double expectedBalance = player.getBalance() + addMoney;


        assertEquals(20.0, expectedBalance,0);



    }
}
