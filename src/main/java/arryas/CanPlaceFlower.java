package arryas;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 * Example 1:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 *
 * Example 2:
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 * -> check at a given point if element is 0
 *  -> if yes check left and right of that element is it 0 or not
 *  --> if yes then plant a flower ==> decrease n
 *  -> check also if point is first or last
 *  -> return if all flowers are planted ==> n==0
 */
public class CanPlaceFlower {
    public static boolean canPlaceFlowers(int[] flowerbed, int flowers) {
        for(int i = 0; i < flowerbed.length && flowers > 0; i++) {
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                i++; //increase 1 more step
                flowers--; //plant a flower
            }
        }
        return flowers == 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int flowers = 1;
        System.out.println(canPlaceFlowers(flowerbed, flowers));
    }
}
