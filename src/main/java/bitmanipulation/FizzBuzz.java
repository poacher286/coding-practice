package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            if (getRemainder(i, 3) ==0 && getRemainder(i, 5)==0)
                output.add("FizzBuzz");
            else if (getRemainder(i, 3) == 0)
                output.add("Fizz");
            else if (getRemainder(i, 5) == 0)
                output.add("Buzz");
            else
                output.add(Integer.toString(i));
        }
        return output;
    }

    private int getRemainder(int num, int divisor){
        return (num - divisor * (num / divisor));
//        while (num >= divisor)
//            num -= divisor;
//
//        return num;
    }
}
