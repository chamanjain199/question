package revision.arrays;

import java.util.Arrays;

public class SmallestPositiveMissingNumber {
    //Function to find the smallest positive number missing from the array.
    //arr[i] == arr[arr[i] - 1] to avoid duplicate for ex (1 ,1,1,1)
    // if first 1 is already moved to its position, then other 1, we can check if they are already  moved to their position
    static int missingNumber(int arr[], int size) {
        for (int i = 0; i < size; ) {
            if (arr[i] > 0 && arr[i] < size &&  arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] != (i + 1)) {
                return (i + 1);
            }
        }
        return size + 1;
    }

    static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        int input[] = new int[]{-25, 38, 24, -17, 7, 31, 43, 8, 20, 49, -33, -11, 19, 13, -28, 44, 23, -3, -19, 12, 32, 40, 42, 41, 7, -35, -29, 7, 24, 41, -3, 1, -19, -29, -13, -10, 4, -20, 48};

        System.out.println(missingNumber(input, input.length));
    }
}
