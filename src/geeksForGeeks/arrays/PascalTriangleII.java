package geeksForGeeks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
    public static List<Integer> getRowOptimal(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        if (rowIndex == 0) {
            return List.of(1);
        }


        ans.add(1);
        long temp = 1;
        for (int i = 0; i < rowIndex; i++) {
            temp = temp * (rowIndex - i) / (i + 1);
            ans.add((int) temp);
        }
        return ans;
    }

    public static List<Integer> getRowOptimal1(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j] + arr[j - 1];
                System.out.println(Arrays.toString(arr));
            }

        return Arrays.asList(arr);
    }

    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<ArrayList<Long>> ans = new ArrayList<>();
        ArrayList<Long> first = new ArrayList<>();
        first.add(1L);
        if (n == 1) {
            return first;
        }
        for (int row = 2; row <= n; row++) {
            ArrayList<Long> newRow = new ArrayList<>();
            ArrayList<Long> prevRow = ans.get(row - 2);
            for (int i = 0; i < row; i++) {
                if (i == 0 || i == row - 1) {
                    newRow.add(1L);
                } else {
                    newRow.add(prevRow.get(i - 1) + prevRow.get(i));
                }
            }
            ans.add(newRow);
        }
        return ans.get(n);


    }


    public static void main(String[] args) {
        System.out.println(getRowOptimal(6));
    }
}
