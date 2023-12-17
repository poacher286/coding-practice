package strings;

public class AOccursBeforeB {
    public static boolean solution(String S) {
        // Implement your solution here
        if (S.length() == 1){
            return true;
        }

        for (int i = 0; i < S.length() - 1; i++){
            if (S.charAt(i+1) < S.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "aaa";
        System.out.println(solution(S));
    }
}
