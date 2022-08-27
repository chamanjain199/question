package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> finalAns = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumRec2(candidates, target, new ArrayList<>(), 0);
        return finalAns;
    }

    private static void combinationSumRec(int[] candidates, int target, ArrayList<Integer> integers, int level) {
        if (target < 0) {
            return;
        }
        if (level == candidates.length) {
            System.out.println(integers);
            if (target == 0) {
                finalAns.add(new ArrayList<>(integers));
            }
            return;
        }
        integers.add(candidates[level]);
        target -= candidates[level];
        combinationSumRec(candidates, target, integers, level);
        integers.remove(integers.size() - 1);
        target += candidates[level];
        combinationSumRec(candidates, target, integers, level + 1);
    }

    // in this question we can not use for loop wala besause here we can pick or unpick an candidate but in loop we can not left any index unpicker
    // we have to select an candidate at each index but by using some break we can do that with loop too
    private static void combinationSumRec2(int[] candidates, int target, ArrayList<Integer> integers, int level) {
        if (target < 0) {
            return;
        }
        if (level == candidates.length) {
            System.out.println(integers);
            if (target == 0) {
                finalAns.add(new ArrayList<>(integers));
            }
            return;
        }
        if (candidates[level] <= target) {
            integers.add(candidates[level]);
            combinationSumRec2(candidates, target - candidates[level], integers, level);
            integers.remove(integers.size() - 1);
        }
        combinationSumRec2(candidates, target, integers, level + 1);
    }

    private void combinationSumRec2(int start, int[] candidates, int currentSum, int target, List<List<Integer>> results, List<Integer> result) {
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] + currentSum > target) continue;
            else if (candidates[i] + currentSum == target) { // due to this condition it will keep picking same element again and again untill it reached value grater than targer
                result.add(candidates[i]);
                results.add(new ArrayList<>(result));
                result.remove(result.size() - 1);
            } else {
                result.add(candidates[i]);
                combinationSumRec2(i, candidates, currentSum + candidates[i], target, results, result);
                result.remove(result.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(finalAns);
        //  finalAns=new ArrayList<>();

    }
}
