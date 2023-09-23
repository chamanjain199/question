package revision.recustion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesOfArray {
    static ArrayList<List<Integer>> ans = new ArrayList<>();

    public static ArrayList<List<Integer>> subSequenceOfArray(int arr[]) {

        subSequenceOfArray(arr, 0, new ArrayList<>());
        return ans;
    }

    public static void subSequenceOfArray(int arr[], int level, List<Integer> list) {
        if (level == arr.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[level]);
        subSequenceOfArray(arr, level + 1, list);
        list.remove(list.size()-1);
        subSequenceOfArray(arr, level + 1, list);
    }

    public static void main(String[] args) {
        System.out.println(subSequenceOfArray(new int[]{1, 2, 3}));
    }
}
