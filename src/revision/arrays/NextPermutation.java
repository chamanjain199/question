package revision.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    static List<Integer> nextPermutation(int N, int arr[]) {
        int smallIndexFromLast = N - 2;
        List<Integer> intList = new ArrayList<Integer>(N);

        while (smallIndexFromLast > -1 && arr[smallIndexFromLast] >= arr[smallIndexFromLast + 1]) {
            smallIndexFromLast--;
        }
        if (smallIndexFromLast == -1) {
            reverse(0, N - 1, arr);
            for (int i : arr)
            {
                intList.add(i);
            }
            return intList;
        }
        int nextElement = N - 1;
        while (nextElement>-1 && arr[nextElement] <= arr[smallIndexFromLast] ) {
            nextElement--;
        }
        swap(smallIndexFromLast, nextElement, arr);
        reverse(smallIndexFromLast + 1, N - 1, arr);
        for (int i : arr)
        {
            intList.add(i);
        }
        return intList;
    }

    public static void reverse(int i, int j, int[] nums) {
        while (i < j) swap(i++, j--, nums);
    }


    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }
}
