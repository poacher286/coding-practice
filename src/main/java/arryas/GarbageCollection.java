package arryas;

/**
 * You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively. Picking up one unit of any type of garbage takes 1 minute.
 *
 * You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.
 *
 * There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.
 *
 * Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.
 *
 * Return the minimum number of minutes needed to pick up all the garbage.
 *
 *
 *
 * Example 1:
 *
 * Input: garbage = ["G","P","GP","GG"], travel = [2,4,3]
 * Output: 21
 */
public class GarbageCollection {
    public static int garbageCollection(String[] garbage, int[] travel) {
        int time = 0;
        int mIdx = 0;
        int pIdx = 0;
        int gIdx = 0;
        for (int i = 0, garbageLength = garbage.length; i < garbageLength; i++) {
            for (char g : garbage[i].toCharArray()) {
                if (g == 'M') {
                    mIdx = i;
                } else if (g == 'P') {
                    pIdx = i;
                } else {
                    gIdx = i;
                }
                time++;
            }
        }

        for (int i = 1; i < travel.length; i++){
            travel[i] += travel[i - 1];
        }

        time += mIdx > 0 ? travel[mIdx - 1] : 0;
        time += pIdx > 0 ? travel[pIdx - 1] : 0;
        time += gIdx > 0 ? travel[gIdx - 1] : 0;

        return time;
    }

    public static void main(String[] args) {
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        System.out.println(garbageCollection(garbage, travel));
    }
}
