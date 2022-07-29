package numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GCDTest {

    @Test
    void gcd() {
        System.out.println(GCD.gcd(5, 10));
        System.out.println(GCD.gcd(5, 7));
        System.out.println(GCD.gcd(5, 25));
    }

    @Test
    void findGCD() {
        System.out.println(GCD.findGCD(new int[]{2,5,6,9,10}));
        System.out.println(GCD.findGCD(new int[]{3,3}));
        System.out.println(GCD.findGCD(new int[]{7,5,6,8,3}));
        System.out.println(GCD.findGCD(new int[]{10,6,9}));
    }
}