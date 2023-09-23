package revision.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWith0Sum {
    static boolean findsum(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            if (sum == 0) {
                return true;
            }
            if (map.get(sum) != null) {
                return true;
            }

            map.put(sum, 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 2, -3, 1, 5};
        System.out.println(findsum(input, input.length));
    }
}
