package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesOfArray {
    static List<List<Integer>> lists = new ArrayList<>();
    static List<List<Integer>> listsWithGivenSum = new ArrayList<>();

    public static void subSequenceOfArray(int arr[], int level, List<Integer> list) {
        if (level == arr.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[level]);
        subSequenceOfArray(arr, level + 1, list);
        list.remove(list.size() - 1);
        subSequenceOfArray(arr, level + 1, list);
    }

    public static void allSubSequenceOfArrayWithGivenSum(int arr[], int level, List<Integer> list, int sum, int givenSum) {

        if (level == arr.length) {
            if (sum == givenSum) {
                listsWithGivenSum.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(arr[level]);
        sum += arr[level];
        allSubSequenceOfArrayWithGivenSum(arr, level + 1, list, sum, givenSum);
        list.remove(list.size() - 1);
        sum -= arr[level];
        allSubSequenceOfArrayWithGivenSum(arr, level + 1, list, sum, givenSum);
    }

    public static void allSubSequenceOfArrayWithGivenSum2(int arr[], int level, List<Integer> list, int sum, int givenSum) {

        if (level == arr.length) {
            System.out.println(" list " + list);
            if (sum == givenSum) {
                listsWithGivenSum.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = level; i < arr.length; i++) {
            list.add(arr[i]);
            allSubSequenceOfArrayWithGivenSum2(arr, i + 1, list, sum + arr[i], givenSum);
            list.remove(list.size() - 1);
        }
        // not picking condition
        allSubSequenceOfArrayWithGivenSum2(arr, arr.length, list, sum, givenSum);

    }

    public static void allSubSequenceOfArrayWithGivenSum3(int arr[], int level, List<Integer> list, int sum, int givenSum) {
        if (sum == givenSum) {
            listsWithGivenSum.add(new ArrayList<>(list));
            return;
        }
        if (level == arr.length) {
            return;
        }
        for (int i = level; i < arr.length; i++) {
            list.add(arr[i]);
            allSubSequenceOfArrayWithGivenSum2(arr, i + 1, list, sum + arr[i], givenSum);
            list.remove(list.size() - 1);
        }


    }

    public static boolean anySubSequenceOfArrayWithGivenSum(int arr[], int level, List<Integer> list, int sum, int givenSum) {

        if (level == arr.length) {
            if (sum == givenSum) {
                listsWithGivenSum.add(new ArrayList<>(list));
                return true;
            }
            return false;
        }
        list.add(arr[level]);
        sum += arr[level];
        if (anySubSequenceOfArrayWithGivenSum(arr, level + 1, list, sum, givenSum)) {
            return true;
        }
        list.remove(list.size() - 1);
        sum -= arr[level];
        if (anySubSequenceOfArrayWithGivenSum(arr, level + 1, list, sum, givenSum)) {
            return true;
        }

        return false;
    }

    public static int countAllSubSequenceOfArrayWithGivenSum(int arr[], int level, int sum, int givenSum) {

        if (level == arr.length) {
            if (sum == givenSum) {
                return 1;
            }
            return 0;
        }
        sum += arr[level];
        int l = countAllSubSequenceOfArrayWithGivenSum(arr, level + 1, sum, givenSum);
        sum -= arr[level];
        int r = countAllSubSequenceOfArrayWithGivenSum(arr, level + 1, sum, givenSum);


        return l + r;
    }

    public static void main(String[] args) {
//        subSequenceOfArray(new int[]{3, 2, 1}, 0, new ArrayList<>());
//        System.out.println(lists);
        allSubSequenceOfArrayWithGivenSum3(new int[]{1, 2, 1}, 0, new ArrayList<>(), 0, 2);
        System.out.println(listsWithGivenSum);
        listsWithGivenSum = new ArrayList<>();
//        allSubSequenceOfArrayWithGivenSum2(new int[]{1, 2, 1}, 0, new ArrayList<>(), 0, 2);
//        System.out.println(listsWithGivenSum);
//        anySubSequenceOfArrayWithGivenSum(new int[]{1, 2, 1}, 0, new ArrayList<>(), 0, 2);
//        System.out.println(listsWithGivenSum);
//        System.out.println( countAllSubSequenceOfArrayWithGivenSum(new int[]{1, 2, 1}, 0, 0, 2));
    }
}
