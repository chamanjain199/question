package geeksForGeeks.recurtion.pcs.subsets;

import java.util.ArrayList;
import java.util.List;

public class SubSetsOfArray {
    final static List<List<Integer>> finalList = new ArrayList<>();

    public static List<List<Integer>> findAllSubSets(int[] arr) {
        helperSubSetsForLoop(arr, arr.length, new ArrayList<>(), 0);
//        helperSubSetsPickAndNotPick(arr, arr.length, new ArrayList<>(), 0);
//        helperSubSetsBitManipulation(arr);
        return finalList;
    }

    private static void helperSubSetsForLoop(int[] arr, int size, List<Integer> subSet, int level) {
        finalList.add(new ArrayList<>(subSet));

        for (int i = level; i < size; i++) {
            subSet.add(arr[i]);
            helperSubSetsForLoop(arr, size, subSet, i + 1);
            subSet.remove(subSet.size() - 1);
        }
    }

    private static void helperSubSetsPickAndNotPick(int[] arr, int size, List<Integer> subSet, int level) {
        if (level == size) {
            finalList.add(new ArrayList<>(subSet));
            return;
        }
        helperSubSetsPickAndNotPick(arr, size, subSet, level + 1);
        subSet.add(arr[level]);
        helperSubSetsPickAndNotPick(arr, size, subSet, level + 1);
        subSet.remove(subSet.size() - 1);
    }

    private static void helperSubSetsBitManipulation(int[] arr) {
        long pow = (long) Math.pow(2, arr.length);
        for (int i = 0; i < pow; i++) {
            List<Integer> subSet = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if (((i >> j) & 1) == 1) {
                    subSet.add(arr[j]);
                }
            }
            finalList.add(subSet);
        }
    }


    public static void main(String[] args) {
        System.out.println(findAllSubSets(new int[]{1, 2, 3}));
    }
}
