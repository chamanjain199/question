package revision.recustion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumll {
    List<List<Integer>> ans;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, new ArrayList<>(), 0, 0);
        return ans;
    }

    private void combinationSumHelper(int[] candidates, int target, List<Integer> temp, int index, int sum) {
        if (target == sum) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i - 1] == candidates[i]) { //i>index because in case of 1,1,1 // we can choose second one if first one is also included but if first one is not included that means
                                                                   // we have already complete sequence that start with 1 so no need to calculate another one that also start with oen
                continue;
            }
            if ((sum + candidates[i]) > target) {
                break;
            }
            temp.add(candidates[i]);
            combinationSumHelper(candidates, target, temp, i + 1, sum + candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
