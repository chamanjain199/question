package revision.recustion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        combinationSumHelper(candidates, target, new ArrayList<>(), 0, 0);
        return ans;
    }

    private void combinationSumHelper(int[] candidates, int target, List<Integer> temp, int index, int sum) {
        if (index == candidates.length) {
            if (target == sum) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if ((sum + candidates[index]) <= target) {
            temp.add(candidates[index]);
            combinationSumHelper(candidates, target, temp, index, sum + candidates[index]);
            temp.remove(temp.size() - 1);
        }
        combinationSumHelper(candidates, target, temp, index + 1, sum);
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int input[] = {2, 3, 6, 7};
        System.out.println(obj.combinationSum(input, 7));
    }
}
