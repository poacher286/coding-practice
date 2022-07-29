package strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParanthesisTest {

    @Test
    void isValid() {
        String str = "{{]]{";
        String str1 = "[][][][][]";
        String str2 = "[[[[{({})}]]]]";
        String str3 = "{}{}()()[]}";
        Assertions.assertFalse(ValidParanthesis.isValid(str));
        Assertions.assertTrue(ValidParanthesis.isValid(str1));
        Assertions.assertTrue(ValidParanthesis.isValid(str2));
        Assertions.assertFalse(ValidParanthesis.isValid(str3));
    }
}