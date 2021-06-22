package numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArmstrongTest {
    @Test
    public void testArmStrong() {
        List<Integer> list = IntStream.rangeClosed(1000, 20000)
                .boxed()
                .parallel()//to improve performance
                .filter(Armstrong::isArmstrong)
                .collect(Collectors.toList());

        System.out.println("Armstrong list : "+list);
        Assertions.assertTrue(list.size()>=3);

    }
}
