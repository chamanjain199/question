package leetcode.daily.challenge;

import java.util.Arrays;

public class MaximumPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int sum;
        int minSum = 0;
        int len = cardPoints.length;
        int minArraySize = len - k;
        for (int i = 0; i < minArraySize; i++) {
            minSum += cardPoints[i];
        }
        int tempSum = minSum;
        sum = minSum;
        for (int i = minArraySize; i < len; i++) {
            tempSum += cardPoints[i] - cardPoints[i - minArraySize];
            if (tempSum < minSum) {
                minSum = tempSum;
            }
            sum += cardPoints[i];
        }
        return sum - minSum;

    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{32, 69, 37, 79, 4, 33, 29, 33, 45, 1, 99, 90, 56, 24, 76}, 10));
    }
}
