package geeksForGeeks.recurtion;

import java.util.*;

public class CombinationSumII {

    List<List<Integer>> finalAns = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumSolve(candidates, target, new ArrayList<>(), 0);
        return finalAns;
    }
    private void combinationSumSolve(int[] candidates, int target, ArrayList<Integer> combinations, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            finalAns.add(new ArrayList<>(combinations));
            return;
        }

        if (index == candidates.length) {

            return;
        }

        for (int i = index; i <candidates.length; i++) {
            if (!validateInitialDuplicateCandidate(i, candidates,index)) {
                combinations.add(candidates[i]);
                combinationSumSolve(candidates, target - candidates[i], combinations, i + 1);
                combinations.remove(combinations.size() - 1);
            }
        }
    }

    private boolean validateInitialDuplicateCandidate(int i,int[] candidates,int level) {
        //i>index: at each level we allow to pick same element selected in previous level because at different  level
        // we can select duplicate element
        // but at same level we can not select duplicate element
        //i==level meas selecting first element at level level
        //i>level== from second element at same level
        return i > level && candidates[i - 1] == candidates[i];
    }

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();

        System.out.println(combinationSumII.combinationSum2(new int[]{1,1,1,2,2}, 4));
    }
}
