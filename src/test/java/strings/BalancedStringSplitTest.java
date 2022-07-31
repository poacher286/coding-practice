package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedStringSplitTest {

    @Test
    void balancedStringSplit() {
        assertEquals(4, BalancedStringSplit.balancedStringSplit("RLRRLLRLRL"));
    }
}