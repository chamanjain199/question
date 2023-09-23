package revision.arrays;

public class TrappingRainWater {
    public int trap(int[] height) {
        int len = height.length;
        int totalWater = 0;
        int[] lmax = new int[len];
        int[] rmax = new int[len];
        lmax[0] = height[0];
        for (int i = 1; i < len; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        rmax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }
        for (int i = 1; i < len-1; i++) {
            totalWater += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return totalWater;
    }
}
