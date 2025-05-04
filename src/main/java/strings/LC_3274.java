package strings;

public class LC_3274 {
    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int c1 = coordinate1.charAt(0) + coordinate1.charAt(1);
        int c2 = coordinate2.charAt(0) + coordinate2.charAt(1);
        return (c1 % 2 == 0 && c2 % 2 == 0) || (c1 % 2 != 0 && c2 % 2 != 0);
    }

    public static void main(String[] args) {
        System.out.println((int) '1');
        System.out.println(checkTwoChessboards("a1", "c3"));
    }
}
