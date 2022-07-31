package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellInRangeTest {

    @Test
    void cellsInRange() {
        assertEquals(6, CellInRange.cellsInRange("A1:F1").size());
    }
}