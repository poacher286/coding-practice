package bitmanipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckIthBitIsOneTest {

    @Test
    void checkIthBitIsOne() {
        assertTrue(CheckIthBitIsOne.checkIthBitIsOne(7, 2));
        assertTrue(CheckIthBitIsOne.checkIthBitIsOne(8, 3));
        assertTrue(CheckIthBitIsOne.checkIthBitIsOne(13, 2));
        assertTrue(CheckIthBitIsOne.checkIthBitIsOne(34, 5));
        assertTrue(CheckIthBitIsOne.checkIthBitIsOne(7, 1));
    }
}