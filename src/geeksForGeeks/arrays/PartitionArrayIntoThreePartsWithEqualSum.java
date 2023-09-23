package geeksForGeeks.arrays;

//https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
public class PartitionArrayIntoThreePartsWithEqualSum {

    public static boolean canThreePartsEqualSum(int[] arr) {
        int len = arr.length;
        int totalSum = 0;
        for (int i = 1; i < len; i++) {
            arr[i] += arr[i - 1];
        }
        totalSum = arr[len - 1];
        if (totalSum % 3 != 0) {
            return false;
        }
        int requiredSum = totalSum / 3;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == requiredSum) {
                count++;
                if (requiredSum != 0 && count == 2) {
                    return true;
                }
                if (requiredSum == 0 && count == 3) {
                    return true;
                }
                requiredSum += requiredSum;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
    }
}
