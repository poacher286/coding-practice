package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStringTest {

    @Test
    void addStrings() {
        String a = "23423";
        String b = "345";
        assertEquals(AddString.addStrings(a, b), String.valueOf(Integer.parseInt(a) + Integer.parseInt(b)));
    }
}