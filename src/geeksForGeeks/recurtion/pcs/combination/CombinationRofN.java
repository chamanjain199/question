package geeksForGeeks.recurtion.pcs.combination;

import java.util.ArrayList;
import java.util.List;

public class CombinationRofN {
    final static List<List<Integer>> finalList = new ArrayList<>();
    public static List<List<Integer>> findAllCombinationRofN(int[] arr,int r) {
        helperSubSetsForLoop(arr, arr.length, new ArrayList<>(), 0,r);
        return finalList;
    }
    private static void helperSubSetsForLoop(int[] arr, int size, List<Integer> subSet, int level,int r) {
        if (subSet.size() == r) {
            finalList.add(new ArrayList<>(subSet));
        }
        for (int i = level; i < size; i++) {
            subSet.add(arr[i]);
            helperSubSetsForLoop(arr, size, subSet, i + 1,r);
            subSet.remove(subSet.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findAllCombinationRofN(new int[]{1,2,3,4},4));
    }
}
