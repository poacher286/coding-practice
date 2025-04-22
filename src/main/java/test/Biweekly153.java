package test;

public class Biweekly153 {
    public int reverseDegree(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            int rev = 'z' - s.charAt(i) + 1;
            sum += rev * (i + 1);
        }
        return sum;
    }
}
