package geeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SubarrayWithGivenSum {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> result = new ArrayList<>();
        int startIndex = 0;
        int endIndex = 0;
        int i = 0;
        int sum = 0;
        while (i < n) {
            int tsum = sum + arr[i];
            if (tsum == s) {
                sum = tsum;
                endIndex = i;
                break;
            } else if (tsum > s) {
                sum -= arr[startIndex++];
            } else {
                sum = tsum;
                i++;
            }
        }
        if (sum == s) {
            result.add(startIndex + 1);
            result.add(endIndex+1);
        } else {
            result.add(-1);
        }
        return result;
    }

    static ArrayList<Integer> subarraySumOld(int[] arr, int n, int s) {
        int currentTotal = 0;
        int startIndex = 0;
        int endIndex = 0;
        int i = 0;
        for (; i < arr.length; ) {
            int tempSum = currentTotal + arr[i];
            if (tempSum < s) {
                currentTotal += arr[i];
                endIndex++;
                i++;
            } else if (tempSum == s) {
                currentTotal += arr[i];
                break;

            } else {
                currentTotal -= arr[startIndex++];
            }

        }

        ArrayList<Integer> arrList = new ArrayList<>();
        if (currentTotal == s) {
            arrList.add(startIndex + 1);
            arrList.add(endIndex + 1);
        } else {
            arrList.add(-1);

        }
        return arrList;
    }

    public static void main(String[] args) {
        String s = "5 6 8 66";
        String ars[] = s.split(" ");
        int arrs[] = Arrays.stream(ars)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(subarraySum(arrs, 4, 66));

    }
}
