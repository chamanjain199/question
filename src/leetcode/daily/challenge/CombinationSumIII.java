package leetcode.daily.challenge;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
     List<List<Integer>> result = new ArrayList<>();
     List<Integer> comb = new ArrayList<>();

    public  List<List<Integer>> combinationSum3(int k, int n) {

        combinationSum(1, k , n);
        return result;
    }

    private  void combinationSum(int init, int k, int n) {

        if(n<0){
            return;
        }

        if (k == 0 && n == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }

        for (int i = init; i < 10 && i<n; i++) {
            comb.add(i);
            combinationSum(i + 1, k -1, n - i);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII sb=new CombinationSumIII();
        System.out.println(sb.combinationSum3(3,7));

    }
}