package twoPointers;

import java.util.Arrays;

/**
 * You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player. Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.
 *
 * The chemistry of a team is equal to the product of the skills of the players on that team.
 *
 * Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams such that the total skill of each team is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: skill = [3,2,5,1,3,4]
 * Output: 22
 * Explanation:
 * Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
 * The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
 */
public class DevidePlayerOfEqualSkill {
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int leftPointer = 0;
        int rightPointer = skill.length - 1;
        int targetSkillPoint = skill[leftPointer] + skill[rightPointer];
        long chemistry = 0;
        while (leftPointer < rightPointer){
            if (skill[leftPointer] + skill[rightPointer] != targetSkillPoint){
                return -1;
            }
            chemistry += (long) skill[leftPointer++] * skill[rightPointer--];
        }
        return chemistry;
    }

    public static void main(String[] args) {
        int[] skill = {3,2,5,1,3,4};
        System.out.println(dividePlayers(skill));
    }
}
