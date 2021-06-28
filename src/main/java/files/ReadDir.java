package files;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReadDir {
    public static void main(String[] args) {
        System.out.println(getFiles(System.getProperty("user.dir") + "/src/main"));
    }

    static List<String> files = new ArrayList<>();

    public static List<String> getFiles(String path) {
        File file = new File(path);
        Arrays.stream(Objects.requireNonNull(file.listFiles()))
                .parallel()
                .filter(File::exists)
                .forEach(f -> {
                    if (f.isFile()) {
                        files.add(f.getAbsolutePath());
                    } else {
                        getFiles(f.getAbsolutePath());
                    }
                });
        return files;
    }
}
