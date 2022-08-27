package geeksForGeeks.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetWithDuplicate {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = (int) Math.pow(2, nums.length);
        List<List<Integer>> list = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            if (!list.contains(temp))
                list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2, 2}));
    }
}
