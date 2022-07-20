package bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvenOddTest {
    @Test
    public void testEvenOddNumbers(){
        Assertions.assertTrue(EvenOdd.isEven(2));
        Assertions.assertFalse(EvenOdd.isEven(1));
        Assertions.assertTrue(EvenOdd.isEven(0));
        Assertions.assertTrue(EvenOdd.isEven(6));
    }
}
