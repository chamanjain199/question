package geeksForGeeks;

import java.util.Arrays;
import java.util.HashSet;

public class SortedDuplicates {
    public static void SortedDuplicates(int arr[], int n) {
        Arrays.sort(arr);
        HashSet<Integer> hashSet = new HashSet<>(n);
        HashSet<Integer> hashSetPrinted = new HashSet<>(n);
        for (Integer num :
                arr) {
            if (!hashSet.add(num) && hashSetPrinted.add(num)) {
                System.out.print(num + " ");
            }
        }
        if (hashSet.size() == n) {
            System.out.print("-1");
        }
    }

    public static void main(String[] args) {
        SortedDuplicates(new int[]{8148, 9545, 9722, 9722, 9722,10271, 11420, 14418}, 7);
    }
}
