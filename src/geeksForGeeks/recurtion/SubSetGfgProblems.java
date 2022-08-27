package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubSetGfgProblems {

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> finalAns = new ArrayList<>();
        allSubsetsOfGivenArray2(finalAns, new ArrayList<>(),
                A, 0, A.size());
        finalAns.sort((l1, l2) -> {
            int minLength = Math.min(l1.size(), l2.size());
            for (int i = 0; i < minLength; i++) {
                int lexicographicalPosition = l1.get(i).compareTo(l2.get(i));
                if (lexicographicalPosition != 0) {
                    return lexicographicalPosition;
                }
            }
            return Integer.compare(l1.size(), l2.size());
        });
        return finalAns;
    }

    private static void allSubsetsOfGivenArray(ArrayList<ArrayList<Integer>> finalAns, ArrayList<Integer> subSet,
                                               ArrayList<Integer> givenArray, int level, int size) {
        if (level == size) {
            finalAns.add(new ArrayList<>(subSet));
            return;
        }
        subSet.add(givenArray.get(level));
        allSubsetsOfGivenArray(finalAns, subSet,
                givenArray, level + 1, size);
        subSet.remove(subSet.size() - 1);
        allSubsetsOfGivenArray(finalAns, subSet,
                givenArray, level + 1, size);
    }

    private static void allSubsetsOfGivenArray2(ArrayList<ArrayList<Integer>> finalAns, ArrayList<Integer> subSet,
                                                ArrayList<Integer> givenArray, int level, int size) {
        finalAns.add(new ArrayList<>(subSet));

        for (int i = level; i < size; i++) {
            subSet.add(givenArray.get(i));
            allSubsetsOfGivenArray2(finalAns, subSet,
                    givenArray, i + 1,
                    size);
            subSet.remove(subSet.size() - 1);
        }

    }

    //========================================================================================================================

    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {

        ArrayList<ArrayList<Integer>> finalAns = new ArrayList<>();
        allSubsetsOfGivenArray(finalAns, new ArrayList<>(),
                null, 0, n);
        finalAns.sort((l1, l2) -> {
            int minLength = Math.min(l1.size(), l2.size());
            for (int i = 0; i < minLength; i++) {
                int lexicographicalPosition = l1.get(i).compareTo(l2.get(i));
                if (lexicographicalPosition != 0) {
                    return lexicographicalPosition;
                }
            }
            return Integer.compare(l1.size(), l2.size());
        });
        return finalAns;
    }

    private static void allUniqueSubsetsOfGivenArray(ArrayList<ArrayList<Integer>> finalAns, ArrayList<Integer> subSet,
                                                     ArrayList<Integer> givenArray, int level, int size) {
        if (level == size) {
            finalAns.add(new ArrayList<>(subSet));
            return;
        }
        subSet.add(givenArray.get(level));
        allSubsetsOfGivenArray(finalAns, subSet,
                givenArray, level + 1, size);
        subSet.remove(subSet.size() - 1);
        allSubsetsOfGivenArray(finalAns, subSet,
                givenArray, level + 1, size);
    }

    //============================================================================================================
//https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
    static Boolean isSubsetSum(int N, int arr[], int sum) {
        return isSubsetSumHelper(arr.length, arr, sum, 0);
    }

    private static boolean isSubsetSumHelper(int size, int arr[], int sum, int index) {
        if (sum < 0) {
            return false;
        }
        if (sum == 0) {

            return true;
        }
        for (int i = index; i < size; i++) {
            if (isSubsetSumHelper(size, arr, sum - arr[i], i + 1)) {
                return true;
            }
        }
        return false;
    }

    //===========================================================================================================
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> finalAns = new ArrayList<>();
        subsetSumsHelper(arr, N, 0, 0, finalAns);
        return finalAns;
    }

    private static void subsetSumsHelper(ArrayList<Integer> arr, int N, int sum, int index, ArrayList<Integer> finalAns) {
        finalAns.add(sum);
        for (int i = index; i < N; i++) {
            subsetSumsHelper(arr, N, sum + arr.get(i), i + 1, finalAns);
        }

    }

    //================================================================================================
    public String isSubset(long a1[], long a2[], long n, long m) {
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a1[i], map.getOrDefault(a1[i], 0L) + 1);
        }
        for (int i = 0; i < a2.length; i++) {
            Long value = map.get(a2[i]);
            if (value != null && value > 0) {
                map.put(a2[i], value);
            } else {
                return "No";
            }
        }
        return "Yes";

    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(subsets(arrayList));
        System.out.println(subsetSums(arrayList, 3));

    }
}
