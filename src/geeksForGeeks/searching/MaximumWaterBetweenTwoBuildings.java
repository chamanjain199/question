package geeksForGeeks.searching;

public class MaximumWaterBetweenTwoBuildings {
    static int maxWater(int height[], int n) {
        int maxWater = 0;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            maxWater = Math.max(maxWater, (high - low - 1) * Math.min(height[low], height[high]));

            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = {2, 1, 3, 4, 6, 5};
        System.out.println(maxWater(height, height.length));
    }

}
