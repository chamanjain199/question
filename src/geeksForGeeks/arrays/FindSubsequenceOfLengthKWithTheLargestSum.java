package geeksForGeeks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindSubsequenceOfLengthKWithTheLargestSum {
    int maxSum = Integer.MIN_VALUE;
    List<Integer> ansList;

    public int[] maxSubsequence(int[] nums, int k) {
        ansList = new ArrayList<>();
        maxSubsequenceTLE(nums, k, 0, 0, new ArrayList<>());
        return ansList.stream().mapToInt(x -> x).toArray();
    }


    public void maxSubsequenceTLE(int[] nums, int k, int sum, int index, List<Integer> tempList) {
        if (tempList.size() == k) {
            if (sum > maxSum) {
                maxSum = sum;
                ansList = new ArrayList<>(tempList);
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            maxSubsequenceTLE(nums, k, (sum + nums[i]), i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public int[] maxSubsequence2(int[] nums, int k) {
        int len = nums.length;
        int[][] twoDArray = new int[len][2];
        for (int i = 0; i < len; i++) {
            twoDArray[i][0] = nums[i];
            twoDArray[i][1] = i;
        }
        Arrays.sort(twoDArray, Comparator.comparingInt(x -> x[0]));
        Arrays.sort(twoDArray, len - k, len, Comparator.comparingInt(x -> x[1]));
        int[] ans = new int[k];
        for (int i = len - k, j = 0; i < len; i++, j++) {
            ans[j] = twoDArray[i][0];
        }
        return ans;
    }

    public static void main(String[] args) {
        FindSubsequenceOfLengthKWithTheLargestSum obj = new FindSubsequenceOfLengthKWithTheLargestSum();
        int[] input = new int[]{18, 3, 19, -8, 30, 22, -35, 11, 16, 18, -21, 32, -7, -6, 38, 25, -21, -1, 26, -8, -37, -39, -34, 6, -36, -3, 26, -32, 22, -20, 35, -35, -30, -8, 11, 7, -23, -9, -22, 1, 33, -6, 12, 2, 27, -27, 28, -12, 21, 12, 16, 21, 33};
        System.out.println(Arrays.toString(obj.maxSubsequence2(input, 50)));

    }
}