package numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeTest {
    @Test
    public void testPrime() {
        List<Integer> list = IntStream.rangeClosed(10000, 20000)
                .boxed()
                .parallel()//to improve performance
                .filter(Prime::isPrime)
                .collect(Collectors.toList());

        System.out.println("Prime list : "+list);
        Assertions.assertTrue(list.size()>5);

    }
}
