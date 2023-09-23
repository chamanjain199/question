package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class SubarrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        int sum = 0;
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i < n && sum < s) {
            sum += arr[i++];
            while (sum > s) {  // after we need to check if sum is greater than s, we can do it in next loop because i might be equal to n
                sum -= arr[j++];
            }
            if (sum == s) {
                ans.add(j + 1);
                ans.add(i);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }

    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum2(int[] arr, int n, int s) {
        int sum = 0;
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (sum < s && i<n) {
            sum += arr[i];
            i++;
        }
        if(s==0){
            ans.add(-1);
            return ans;
        }
        while (i < n) {
            if (sum > s) {
                sum -= arr[j];
                j++;
            } else if (sum == s) {
                ans.add(j + 1);
                ans.add(i );
                return ans;
            } else {
                sum += arr[i];
                i++;
            }
        }
        while (sum > s) {
            sum -= arr[j];
            j++;
        }
        if (sum == s) {
            ans.add(j + 1);
            ans.add(i);
            return ans;
        }
        ans = new ArrayList<>();
        ans.add(-1);
        return ans;
    }


    public static void main(String[] args) {
        int[] input = {135,101,170,125,79,159,163,65,106,146,82,28,162,92,196,143,28,37,192,5,103,154,93,183,22,117,119,96,48,127,172,139,70,113,68,100,36,95,104,12,123,134};
        int sum = 468;
        System.out.println(subarraySum2(input, input.length, sum));
    }
}
