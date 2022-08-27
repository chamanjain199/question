package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

public class AllUniquePermutationsOfAnArray {
     ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

     BitSet bs = new BitSet();

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        AllUniquePermutationsOfAnArray obj=new AllUniquePermutationsOfAnArray();
        Collections.sort(arr);
        allPermutation(arr, new ArrayList<>(),obj);
        return obj.ans;
    }

    public static void allPermutation(ArrayList<Integer> arr, ArrayList<Integer> subSet,AllUniquePermutationsOfAnArray obj) {
        if (subSet.size() == arr.size()) {
            obj.ans.add(new ArrayList<>(subSet));
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (obj.bs.get(i)) {
                continue;
            }
            if (i > 0 && !obj.bs.get(i - 1) && arr.get(i).equals(arr.get(i - 1))) {
                continue;
            }
            obj.bs.set(i);
            subSet.add(arr.get(i));
            allPermutation(arr, subSet,obj);
            subSet.remove(subSet.size() - 1);
            obj.bs.set(i, false);
        }
    }




    public static void main(String[] args) {
        ArrayList<Integer> question = new ArrayList<>();
        question.add(1);
        question.add(3);
        question.add(1);

        System.out.println(uniquePerms(question, 3));
    }
}