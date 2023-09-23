package revision.bitmanipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> finalAns = new ArrayList<>();
        int l = nums.length;
        int len = (int) Math.pow(2, l);
        finalAns.add(new ArrayList<>());
        for (int i = 1; i < len; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < l; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }
            finalAns.add(list);
        }
        return finalAns;

    }

    public static void main(String[] args) {

    }
}
