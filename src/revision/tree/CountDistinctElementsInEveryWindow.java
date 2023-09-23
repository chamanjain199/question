package revision.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInEveryWindow {
    ArrayList<Integer> countDistinct(int A[], int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(map.size());
        for (int i = k ; i < n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            Integer intVal = map.get(A[i - k]);
            if (intVal > 1) {
                map.put(A[i - k], intVal - 1);
            } else {
                map.remove(intVal);
            }
            ans.add(map.size());
        }
        return ans;
    }
}
