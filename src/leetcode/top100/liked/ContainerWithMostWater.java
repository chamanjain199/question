package leetcode.top100.liked;

public class ContainerWithMostWater {
    public static int maxAreaNotworking(int[] height) {
        int start = height[0];
        int end = height[1];
        int maxArea = Math.min(start, end);
        for (int i = 0; i < height.length; i++) {
            height[i] = height[i] * (i);
        }
        for (int i = 2; i < height.length; i++) {
            if (height[i] > end) {
                if (end > start) {
                    start = end;
                }
                end = height[i];
            } else if (height[i] > start) {
                start = end;
                end = height[i];
            }
        }
        if (start < end) {
            return start * start;
        } else {
            return end * end;
        }
    }

    //We are taking full width in consideration then reduce width with taking max height point so that area can be max
    public static int maxArea(int[] heights) {
        int height = 0;
        int width = 0;
        int area = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            width = right - left;
            height = Math.min(heights[right], heights[left]);
            area = Math.max(width * height, area);
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }

        }
        return area;
    }

    public static int maxAreaOptimised(int[] heights) {
        int height = 0;
        int width = 0;
        int area = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            width = right - left;
            height = Math.min(heights[right], heights[left]);
            area = Math.max(width * height, area);
            while (heights[left] <= height && left < right) {
                left++;
            }
            while (heights[right] <= height && left < right) {
                right--;
            }

        }
        return area;
    }
    public static int maxAreaOptimisedPro(int[] heights) {
        int curMinHeight = 0;
        int width = 0;
        int area = 0;
        int left = 0;
        int right = heights.length - 1;
        while (left < right) {
            width = right - left;
            curMinHeight = Math.min(heights[right], heights[left]);
            area = Math.max(width * curMinHeight, area);
            while (heights[left] <= (curMinHeight) && left < right) {
                left++;
            }
            while (heights[right] <= (curMinHeight) && left < right) {
                right--;
            }
            if (heights[left] < (curMinHeight+1)) {
                left++;
            }  if (heights[right] < (curMinHeight+1)) {
                right--;
            }
        }
        return area;
    }

    public static void main(String[] args) {

        System.out.println(maxAreaOptimisedPro(new int[]{1,2,4,3}));

    }
}
