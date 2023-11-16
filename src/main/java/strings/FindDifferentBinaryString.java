package strings;

public class FindDifferentBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        String res = "";
        for (int i = 0; i < nums.length; i++) {
            res += nums[i].charAt(i) == '0' ? "1" : "0";
        }
        return res;
    }
}
