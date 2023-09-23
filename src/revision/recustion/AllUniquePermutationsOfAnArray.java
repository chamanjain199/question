package revision.recustion;


import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;

//https://practice.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1
public class AllUniquePermutationsOfAnArray {

    static ArrayList<ArrayList<Integer>> ans;
    static BitSet bs;

    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ans = new ArrayList<>();
        bs = new BitSet();
        Collections.sort(arr);
        uniquePermsHelper(arr,n,new ArrayList<>());
        return ans;
    }

    static void uniquePermsHelper(ArrayList<Integer> arr, int n, ArrayList<Integer> temp) {
        if (temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (bs.get(i)) {
                continue;
            }
            if (i > 0 && !bs.get(i - 1) && arr.get(i - 1).equals(arr.get(i))) {
                continue;
            }
            bs.set(i);
            temp.add(arr.get(i));
            uniquePermsHelper(arr, n, temp);
            bs.set(i, false);
            temp.remove(temp.size() - 1);
        }
    }
}
