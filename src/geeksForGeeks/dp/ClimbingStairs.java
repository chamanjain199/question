package geeksForGeeks.dp;

public class ClimbingStairs {
    int arr[];

    public int climbStairs(int n) {
        arr = new int[n + 1];
        // int sol1 = climbStairsRec(0, n);
        //int sol2 = climbStairsRec1(n);
        int sol3 = climbStairsRec2(n);
        return sol3;
    }

    public int climbStairsRec2(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }

    public int climbStairsRec(int n, int des) {
        if (n == des) {
            return 1;
        }
        if (n > des) {
            return 0;
        }
        if (arr[n] == 0) {
            arr[n] = climbStairsRec(n + 1, des) + climbStairsRec(n + 2, des);
        }
        return arr[n];
    }

    public int climbStairsRec1(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (arr[n] == 0) {
            arr[n] = climbStairsRec1(n - 1) + climbStairsRec1(n - 2);
        }
        return arr[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println(climbingStairs.climbStairs(3));
    }
}
