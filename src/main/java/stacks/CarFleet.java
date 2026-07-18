package stacks;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    /**
     * There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
     * <p>
     * You are given two integer arrays position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
     * <p>
     * A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
     * <p>
     * A car fleet is a single car or a group of cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
     * <p>
     * If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
     * <p>
     * Return the number of car fleets that will arrive at the destination.
     * <p>
     *
     *
     * Example 1:
     * <p>
     * Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
     * <p>
     * Output: 3
     * <p>
     * Explanation:
     * <p>
     * The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
     * The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
     * The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
     */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        //create 2D car to store position and speed
        int[][] cars = new int[n][2];

        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);//sort desc by position

        Stack<Double> timeStack = new Stack<>();//keep track of time
        for(int[] car : cars){
            double timeTaken = (double)(target - car[0]) / car[1]; //time = distance / speed
            if(timeStack.isEmpty() || timeTaken > timeStack.peek()){
                timeStack.push(timeTaken);//eventually every car has to arrive destination push to stack
            }
        }
        return timeStack.size();
    }
}
