package leetcode.biweekly.contest;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PartitionArraySuchThatMaximumDifferenceIsK {
    public static int partitionArray(int[] nums, int k) {
        Set<Integer> ns = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            ns.add(nums[i]);
        }
        ns = ns.stream().sorted(Collections.reverseOrder(Integer::compareTo)).collect(Collectors.toCollection(LinkedHashSet::new));
        if (k == 0) {
            return ns.size();
        }
        int ans = 0;
        while (!ns.isEmpty()) {
            int extractEl = ns.iterator().next();
            ns.removeIf(x -> extractEl - x <= k);
            ans++;
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{5, 16, 3, 20, 9, 20, 16, 19, 6}, 4));
    }
}
