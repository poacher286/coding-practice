package numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TidyTest {
    @Test
    public void testTidy() {
        List<Integer> list = IntStream.rangeClosed(100, 200)
                .boxed()
                .parallel()//to improve performance
                .filter(Tidy::isTidy)
                .collect(Collectors.toList());

        System.out.println("Tidy list :" +list);
        Assertions.assertTrue(list.size()>5);

    }
}
