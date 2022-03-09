package leetcode.top100.liked;

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int otherCounter = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                otherCounter++;
                nums[otherCounter] = nums[i];
            }

        }
        return otherCounter+1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3,2,2,3};
        System.out.println(removeElement(arr, 3));
        System.out.println(Arrays.toString(arr));


    }
}
