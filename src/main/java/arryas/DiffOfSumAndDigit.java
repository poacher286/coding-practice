package arryas;

public class DiffOfSumAndDigit {
    public static int differenceOfSum(int[] nums) {
        int elementSum = 0;
        int digitSum = 0;
        for (int num : nums) {
            elementSum += num;
            digitSum += digitSum(num);
        }

        return Math.abs(elementSum - digitSum);
    }

    public static int digitSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,15,6,3};
        System.out.println(differenceOfSum(nums));
    }
}
