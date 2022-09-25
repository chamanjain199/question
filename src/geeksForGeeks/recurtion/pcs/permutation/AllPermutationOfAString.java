package geeksForGeeks.recurtion.pcs.permutation;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationOfAString {
    List<String> finalAns = new ArrayList<>();

    public List<String> allPermutationOfAString(String str) {
        int size = str.length();
        boolean[] flag = new boolean[size];
        char[] chars = str.toCharArray();
        helper(chars, size, 0, new StringBuilder(), flag);
        return finalAns;
    }

    private void helper(char[] arr, int size, int index, StringBuilder onePermutation, boolean[] flag) {

        if (index == size) {
            finalAns.add(onePermutation.toString());
        }
        for (int i = 0; i < size; i++) {
            if (!flag[i]) {
                flag[i] = true;
                onePermutation.append(arr[i]);
                helper(arr, size, index + 1, onePermutation, flag);
                onePermutation.deleteCharAt(onePermutation.length() - 1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        AllPermutationOfAString allPermutationOfAString = new AllPermutationOfAString();
        System.out.println(allPermutationOfAString.allPermutationOfAString("ABC"));
    }
}
