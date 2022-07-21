package arryas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindDisappearedNumbersTest {

    @Test
    void findDisappearedNumbers() {
        int[] a = {
                1,
                2,
                3,
                2,
                4,
                5,
                1,
                3
        };
        assertEquals(3, FindDisappearedNumbers.findDisappearedNumbers(a).size());
    }
}