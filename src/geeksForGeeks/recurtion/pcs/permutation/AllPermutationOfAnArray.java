
package geeksForGeeks.recurtion.pcs.permutation;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationOfAnArray {
    List<List<Integer>> finalAns = new ArrayList<>();

    public List<List<Integer>> allPermutationOfArray(int[] arr) {
        int size = arr.length;
        boolean[] flag = new boolean[size];
        // helper(arr, size, 0, new ArrayList<>(), flag);
        helperWithSwap(arr, size, 0, new ArrayList<>());

        return finalAns;
    }

    private void helper(int[] arr, int size, int index, List<Integer> onePermutation, boolean[] flag) {
        if (index == size) {
            finalAns.add(new ArrayList<>(onePermutation));
        }
        for (int i = 0; i < size; i++) {
            if (!flag[i]) {
                flag[i] = true;
                onePermutation.add(arr[i]);
                helper(arr, size, index + 1, onePermutation, flag);
                onePermutation.remove(onePermutation.size() - 1);
                flag[i] = false;
            }
        }
    }

    private void helperWithSwap(int[] arr, int size, int index, List<Integer> onePermutation) {

        if (index == size) {
            finalAns.add(new ArrayList<>(onePermutation));
            return;
        }
        for (int i = index; i < size; i++) {
            onePermutation.add(arr[i]);
            swap(arr, index, i);
            helperWithSwap(arr, size, index + 1, onePermutation);
            swap(arr, index, i);
            onePermutation.remove(onePermutation.size() - 1);

        }
    }

    private static void swap(int[] arr, int i, int j) {
        int numberAtI = arr[i];
        arr[i] =  arr[j];
        arr[j] = numberAtI;
    }


    public static void main(String[] args) {
        AllPermutationOfAnArray allPermutationOfAnArray = new AllPermutationOfAnArray();
        System.out.println(allPermutationOfAnArray.allPermutationOfArray(new int[]{1, 2, 3}));
    }
}
