package geeksForGeeks.bitmanipulation;

import java.util.Arrays;

public class XORQueriesOfASubArray {
    public static int[] xorQueries(int[] arr, int[][] queries) {
        for (int i = 1; i < arr.length; i++) {
            arr[i]^=arr[i-1];
        }
        int[] answer =new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if(queries[i][0]==0) {
                answer[i] = arr[queries[i][1]];
            }else{
                answer[i] = arr[queries[i][0]-1] ^ arr[queries[i][1]];
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
    }

}
