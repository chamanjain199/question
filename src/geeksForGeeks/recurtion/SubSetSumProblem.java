package geeksForGeeks.recurtion;

public class SubSetSumProblem {
    static int count = 0;

    public static int subSetSum(int arr[], int sum) {
        totalSubSetWithSum(arr, sum, 0, 0);
        return count;
    }

    public static void totalSubSetWithSum(int arr[], int sum, int currentSum, int index) {

        if (index == arr.length) {
            if (sum == currentSum)
                count++;
            return;
        }
        totalSubSetWithSum(arr, sum, currentSum, index + 1);
        totalSubSetWithSum(arr, sum, currentSum + arr[index], index + 1);
    }

    public static int totalSubSetWithSum2(int arr[], int sum, int index) {

        if (index == arr.length) {
            return sum == 0 ? 1 : 0;
        }
        return totalSubSetWithSum2(arr, sum, index + 1) + totalSubSetWithSum2(arr, sum - arr[index], index + 1);
    }

    public static int totalSubSetWithSum3(int arr[], int sum, int index, int min, int max) {
        if (index == arr.length) {
            int mySum = min + max;
            if (mySum > -1 && (mySum) <= sum) {
                return 1;
            } else {
                return 0;
            }
        }
        return totalSubSetWithSum3(arr, sum, index + 1, min, max) + totalSubSetWithSum3(arr, sum, index + 1, Math.min(min, arr[index]), Math.max(max, arr[index]));
    }



    public static void main(String[] args) {
        System.out.println(subSetSum(new int[]{10, 5, 2, 3, 6}, 8));
        System.out.println(totalSubSetWithSum2(new int[]{10, 5, 2, 3, 6}, 2, 0));
        System.out.println(totalSubSetWithSum3(new int[]{3, 5, 6, 7}, 9, 0, Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}
