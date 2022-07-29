package numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeTest {
    @Test
    public void testPrime() {
        List<Integer> list1 = IntStream.rangeClosed(10000, 20000)
                .boxed()
                .parallel()//to improve performance
                .filter(Prime::isPrime)
                .collect(Collectors.toList());

        List<Integer> list2 = IntStream.rangeClosed(10000, 20000)
                .boxed()
                .parallel()//to improve performance
                .filter(Prime::isPrimeNew)
                .collect(Collectors.toList());

        int totalPrime = (int) IntStream.range(2, 5000000).boxed().filter(Prime::isPrimeNew).count();
        System.out.println(totalPrime);
        Assertions.assertTrue(totalPrime>100);

        Assertions.assertEquals(list1, list2);

    }
}
