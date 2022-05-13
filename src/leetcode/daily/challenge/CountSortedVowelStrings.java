package leetcode.daily.challenge;

public class CountSortedVowelStrings {
    static int result = 0;

    public static int countVowelStrings(int n) {

            countAll(0, n );
        return result;
    }

    private static void countAll(int init, int n) {

        if (n <=0) {
            result++;
            return;
        }
        for (int i = init; i < 5; i++) {
            countAll(i, n-1);
        }
    }
    public static int countVowelStrings1(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {

            }
            System.out.println();

        }
        return result;
    }

    private static void countAll1(int init, int n) {

        if (n <=0) {
            result++;
            return;
        }
        for (int i = init; i < 5; i++) {
            countAll1(i, n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("ANS " + countVowelStrings1(2));
    }
}