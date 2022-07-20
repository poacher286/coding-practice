package bitmanipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountOnesInBinaryTest {

    @Test
    void count1Test() {
        assertEquals(CountOnesInBinary.count1InBinary(8), 1);
        assertEquals(CountOnesInBinary.count1InBinary(7), 3);
        assertEquals(CountOnesInBinary.count1InBinary(11), 3);
    }
}