package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Replace {
    public static String replaceStr(String arg, String rep1, String rep2) {
        String[] split = arg.split("\\s+");

        List<String> list = new ArrayList<>();

        IntStream.range(0, split.length)
                .forEach(i -> {
                    if (split[i].equals(rep1)) list.add(i, rep2);
                    else list.add(i, split[i]);
                });
        return String.join(" ", list);
    }

    public static void main(String[] args) {
        System.out.println(replaceStr("May Apr Jul Aug", "Apr", "Jun"));
    }
}
