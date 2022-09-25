package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    List<Integer> allNumbers = new ArrayList<>();

    public String getPermutation(int n, int k) {
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
            allNumbers.add(i);
        }
        allNumbers.add(n);
        StringBuilder ans = new StringBuilder();
        k = k - 1;
        while (true) {
            int index = k / fact;
            ans.append(allNumbers.get(index));
            allNumbers.remove(index);
            if (allNumbers.isEmpty()) {
                break;
            }
            k = k % fact;
            fact = fact / (allNumbers.size());
        }
        return ans.toString();

    }


    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(4,1));
    }
}
