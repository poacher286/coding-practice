package collection;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
    /**
     * x,y plane
     * start point (0,0) x=0, y=0
     * path[i] = E  --> (1,0) --> x++, y
     * path[i] = W  --> (-1,0) --> x--, y
     * path[i] = N  --> (0,1) --> x, y++
     * path[i] = S  --> (0,-1) --> x, y--
     * @param path - EWNS
     * @return true if they crosses .
     */
    public static boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;

        Set<String> previouslyVisitedPoints = new HashSet<>();
        String coordinate = "(" + x + "," + y + ")";
        previouslyVisitedPoints.add(coordinate);
        for (char dir : path.toCharArray()) {
            switch (dir){
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                default:
                    break;
            }
            coordinate = "(" + x + "," + y + ")";
            if (!previouslyVisitedPoints.add(coordinate)) return true;
        }
        return false;
    }
}
