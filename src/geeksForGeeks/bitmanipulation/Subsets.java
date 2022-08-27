package geeksForGeeks.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        int len = (int) Math.pow(2, nums.length);
        List<List<Integer>> list = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(nums[j]);
                }
            }
            list.add(temp);
        }
        return list;
    }

    public static List<String> AllPossibleStrings(String s) {
        int size = s.length();
        int len = (int) Math.pow(2, size);
        List<String> list = new ArrayList<>(len);

        for (int i = 1; i < len; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.append(s.charAt(j));
                }
            }
            list.add(temp.toString());
        }
        return list;
    }

    List<List<Integer>> output = new ArrayList();
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            if (k - curr.size() <= n - i) {
                backtrack(i + 1, curr, nums);
            }
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets1(int[] nums) {
        n = nums.length;
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return output;
    }

    public static void subSetRec(String s, String curr) {
        if (s.length() == 0) {
            System.out.print(curr + " ");
            return;
        }
        char first = s.charAt(0);
        String ros = s.substring(1);
        subSetRec(ros, curr + first);
        subSetRec(ros, curr);
    }

    public static void subSetRec1(String s, String curr, int index) {
        if (s.length() == index) {
            System.out.print(curr + " ");
            return;
        }
        subSetRec1(s, curr + s.charAt(index), index + 1);
        subSetRec1(s, curr, index + 1);
    }

    public static void subSetRecArr(int arr[], List<Integer> curr, int index) {
        if (arr.length == index) {
            System.out.print(curr + " ");
            return;
        }
        subSetRecArr(arr, new ArrayList<>(curr), index + 1);
        curr.add(arr[index]);
        subSetRecArr(arr, curr, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{2,3,3,4,6,7}));
        System.out.println(AllPossibleStrings("ABC"));
        subSetRec("ABC", "");
        System.out.println();
        subSetRec1("ABC", "", 0);
        System.out.println();
        subSetRecArr(new int[]{1, 2, 3},new ArrayList<>(),0);
    }
}
