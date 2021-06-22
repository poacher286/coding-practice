package numbers;

import memoization.Fibonacci;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {
    @Test
    void testFibonacci() {
        assertEquals(12586269025L, Fibonacci.fibonacci(50));
    }
}