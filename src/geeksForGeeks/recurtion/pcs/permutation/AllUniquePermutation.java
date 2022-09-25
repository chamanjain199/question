package geeksForGeeks.recurtion.pcs.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllUniquePermutation {
    List<List<Integer>> finalAns = new ArrayList<>();

    public List<List<Integer>> allPermutationOfArray(int[] arr) {
        int size = arr.length;
        boolean[] flag = new boolean[size];
        Arrays.sort(arr);
        helper(arr, size, 0, new ArrayList<>(), flag);
        return finalAns;
    }

    private void helper(int[] arr, int size, int index, List<Integer> onePermutation, boolean[] flag) {

        if (index == size) {
            finalAns.add(new ArrayList<>(onePermutation));
        }
        for (int i = 0; i < size; i++) {
            if (flag[i]) continue;
            if (i > 0 && !flag[i - 1] && arr[i] == arr[i - 1]) continue;

            flag[i] = true;
            onePermutation.add(arr[i]);
            helper(arr, size, index + 1, onePermutation, flag);
            onePermutation.remove(onePermutation.size() - 1);
            flag[i] = false;

        }
    }

    public static void main(String[] args) {
        AllUniquePermutation allUniquePermutation = new AllUniquePermutation();
        System.out.println(allUniquePermutation.allPermutationOfArray(new int[]{1, 1, 3}));
    }
}
