package revision.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {
    static ArrayList<Integer> leaders(int arr[], int n) {
        List<Integer> reverseAns = new ArrayList<>();
        int lastLeaderIndex = n - 1;
        reverseAns.add(arr[lastLeaderIndex]);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[lastLeaderIndex]) {
                lastLeaderIndex = i;
                reverseAns.add(arr[i]);
            }
        }
        int ansSize = reverseAns.size();
        ArrayList<Integer> ans = new ArrayList<>(ansSize);
        for (int i = ansSize - 1; i >= 0; i--) {
            ans.add(reverseAns.get(i));
        }
        return ans;
    }
}
