package revision.recustion;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.IntStream;

public class PermutationsOfArray {

    List<List<Integer>> ans;
    BitSet bs;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        //permuteHelperSwap(nums, nums.length, 0);
        bs = new BitSet();

        permuteHelperRec(nums, nums.length, new ArrayList<>(), 0);

        return ans;
    }

    public void permuteHelperRec(int[] nums, int len, List<Integer> temp, int index) {
        if (index == len) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < len; i++) {  // i start with 0
            if (!bs.get(nums[i])) {
                bs.set(nums[i]);
                temp.add(nums[i]);
                permuteHelperRec(nums, len, temp, index + 1);
                temp.remove(temp.size() - 1);
                bs.set(nums[i], false);
            }

        }
    }

    public void permuteHelperSwap(int[] nums, int len, int index) {
        if (index == len) {
            ans.add(IntStream.of(nums).boxed().toList());
            return;
        }
        for (int i = index; i < len; i++) { // i start with index
            swap(nums, index, i);
            permuteHelperSwap(nums, len, index + 1); //use index, not i, because if we use i then for last number (3) we have nowhere to go , but if we use index// 3 can we swap with 1 and second
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    public static void main(String[] args) {
        PermutationsOfArray obj = new PermutationsOfArray();
        System.out.println(obj.permute(new int[]{1, 2, 3}));
    }
}
