package geeksForGeeks.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumSwapsToSort {
    public static int minSwapsLTE(int nums[]) {
        int len = nums.length;
        int count = 0;
        for (int cs = 0; cs < len - 1; cs++) {
            int item = nums[cs];
            int pos = cs;
            for (int i = cs + 1; i < len; i++) {
                if (nums[i] < item) {
                    pos++;
                }
            }
            int temp = item;
            item = nums[pos];
            nums[pos] = temp;
            while (pos != cs) {

                pos = cs;
                for (int i = cs + 1; i < len; i++) {
                    if (nums[i] < item) {
                        pos++;
                    }
                }
                count++;
                temp = item;
                item = nums[pos];
                nums[pos] = temp;
            }


        }
        return count;
    }

    public static int minSwaps(int nums[]) {
        int len = nums.length;
        int[] sortedArr = new int[len];
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < len; i++) {
            valueToIndex.put(nums[i], i);
            sortedArr[i] = nums[i];
        }
        Arrays.sort(sortedArr);
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != sortedArr[i]) {
                count++;
                int index = valueToIndex.get(sortedArr[i]);
                nums[index] = nums[i];
                valueToIndex.put(nums[i],index);
                nums[i] = sortedArr[i];
                valueToIndex.put(nums[i],i);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,16,14,17,6,9,5,3,18};
        System.out.println(minSwaps(arr));
    }
}
