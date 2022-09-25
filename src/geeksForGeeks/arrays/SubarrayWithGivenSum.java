package geeksForGeeks.arrays;

import java.util.ArrayList;

public class SubarrayWithGivenSum {
    int subArraySum(int arr[], int n, int sum) {
        int lastIndex;
        int localSum = 0;
        for (int i = 0; i < n; i++) {
            lastIndex = i;
            while ((localSum + arr[i]) <= sum) {
                localSum += arr[i];
                i++;
            }
            if (localSum == sum) {
                return 1;
            }
            localSum -= arr[lastIndex];
        }
        return 0;
    }

    //https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int lastIndex = 0;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < n && s > 0) {
            int tempSum = sum + arr[i]; // not adding next element to sum because in case where we have to remove element from beginning // it will also keep adding next
            if (tempSum == s) {
                ans.add(lastIndex + 1);
                ans.add(i + 1);
                return ans;
            }
            if (tempSum < s) {
                sum += arr[i];
                i++;
            } else {
                sum -= arr[lastIndex++];
            }
        }
        ans.add(-1);
        return ans;
    }

    static ArrayList<Integer> subarraySumAnother(int[] arr, int n, int s) {
        int lastIndex = 0;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < n && s > 0) {
             sum = sum + arr[i++];
            while (sum > s) {
                sum -= arr[lastIndex++];
            }
            if (sum == s) {
                ans.add(lastIndex + 1);
                ans.add(i );
                return ans;
            }

        }
        ans.add(-1);
        return ans;
    }




    public static void main(String[] args) {

        System.out.println(subarraySumAnother(new int[]{1, 2, 3, 7, 7}, 5, 14));
    }
}
