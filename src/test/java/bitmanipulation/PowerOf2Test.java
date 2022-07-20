package bitmanipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PowerOf2Test {
    @Test
    public void testPowerOf2(){
        Assertions.assertTrue(PowerOfTwo.isPowerOfTwo(2));
        Assertions.assertFalse(PowerOfTwo.isPowerOfTwo(0));
        Assertions.assertFalse(PowerOfTwo.isPowerOfTwo(23));
        Assertions.assertTrue(PowerOfTwo.isPowerOfTwo(1));
        Assertions.assertTrue(PowerOfTwo.isPowerOfTwo(8));
        Assertions.assertTrue(PowerOfTwo.isPowerOfTwo(256));
    }
}
