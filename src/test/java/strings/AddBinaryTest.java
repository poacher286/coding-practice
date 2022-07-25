package strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {

    @Test
    void addBinary() {
        String s1 = "1001";
        String s2 = "0011";

        System.out.println(AddBinary.addBinary(s1, s2));
    }
    @Test
    void addBinary1() {
        String s1 = "100";
        String s2 = "0011";
        System.out.println(AddBinary.addBinary(s1, s2));
    }
    @Test
    void addBinary2() {
        String s1 = "1001";
        String s2 = "011";
        System.out.println(AddBinary.addBinary(s1, s2));
    }

    @Test
    void addBinary3() {
        String s1 = "11";
        String s2 = "1";
        System.out.println(AddBinary.addBinary(s1, s2));
    }
}