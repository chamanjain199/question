package geeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayInsertAtIndex {

    public static void insertAtIndex(int arr[], int sizeOfArray, int index, int element) {
        if (index != sizeOfArray - 1) {

            for (int i = sizeOfArray - 1; i > index; i--) {
                arr[i] = arr[i - 1];

            }
        }
        arr[index] = element;

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5,0};
        insertAtIndex(arr, 6, 2, 90);

        System.out.println(Arrays.toString(arr));
    }
}
