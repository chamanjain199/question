package geeksForGeeks.arrays;

public class MaximumDifferenceProblemWithOrder {
    static int findMaxDiff(int a[], int n) {
        int rel = a[1] - a[0];
        int minValue = a[0];
        for (int i = 1; i < n; i++) {
            rel = Math.max(rel, a[i] - minValue);
            minValue = Math.min(minValue, a[i]);
        }
        return rel;
    }

    static int maximumDifference(int nums[]) {
        int n = nums.length;
        int rel = -1;
        int minValue = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > minValue) {
                rel = Math.max(rel, nums[i] - minValue);
            } else {
                minValue = Math.min(minValue, nums[i]);
            }
        }

        return rel;
    }

    public static void main(String[] args) {
        int[] a = {30, 10, 8, 2};
        System.out.println(findMaxDiff(a, a.length));
        System.out.println(maximumDifference(a));

    }
}
