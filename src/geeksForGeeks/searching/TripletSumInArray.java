package geeksForGeeks.searching;

import java.util.Arrays;
import java.util.List;

public class TripletSumInArray {

    public static boolean find3Numbers(int A[], int n, int X) {

        Arrays.sort(A);
        for (int i = 0; i <n; i++) {
            if (twoSum(A, (X - A[i]), i + 1)) {
                return true;
            }
        }
        return false;

    }

    public static boolean twoSum(int[] a, int sum, int start) {
        int end = a.length - 1;
        while (start < end) {
            int tsum = a[start] + a[end];
            if (tsum == sum) {
                return true;
            }
            if (tsum > sum) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int A[]=new int[]{557,217,627,358,527,358,338,272,870,362,897,23,618,113,718,697,586,42,424,130,230,566,560,933};
        System.out.println( find3Numbers(A,A.length,986));

    }
}
