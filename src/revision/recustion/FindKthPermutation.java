package revision.recustion;

import java.util.ArrayList;
import java.util.List;

public class FindKthPermutation {

    public static String kthPermutation(int n, int k) {
        int fact = 1;
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact *= i;
            allNumbers.add(i);
        }
        allNumbers.add(n);
        k = k - 1;
        StringBuilder ans = new StringBuilder();
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
}
