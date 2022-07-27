package collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathCrossingTest {

    @Test
    void isPathCrossing() {
        String path = "NES";
        System.out.println("Path : "+path);
        System.out.println("Intersaction : "+PathCrossing.isPathCrossing(path));
        assertFalse(PathCrossing.isPathCrossing(path));
    }

    @Test
    void isPathCrossing1() {
        String path = "NESWW";
        System.out.println("Path : "+path);
        System.out.println("Intersaction : "+PathCrossing.isPathCrossing(path));
        assertTrue(PathCrossing.isPathCrossing(path));
    }
}