package leetcode.top100.liked;

import java.util.*;
import java.util.logging.StreamHandler;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sum3 {


    public static List<List<Integer>> threeSumBruteforce(int[] nums) {
        if (nums.length <= 2) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum > 0) {
                        r--;
                    } else if (sum < 0) {
                        l++;
                    } else {
                        result.add(List.of(nums[i], nums[l], nums[r]));
                        l++;
                        while (nums[l] == nums[l - 1] && l < r) {
                            l++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(threeSumBruteforce(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSumBruteforce(new int[]{0, 0, 0, 0}));
        System.out.println(threeSumBruteforce(new int[]{1, 2, -2, -1}));
        System.out.println(threeSumBruteforce(new int[]{-2, 0, 0, 2, 2}));


    }
}
