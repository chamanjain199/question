package geeksForGeeks.recurtion;

import javax.xml.transform.Source;
import java.util.Arrays;

public class ReverseArrayUsingRec {
    void rev(int arr[], int i) {
        if (i == ((arr.length / 2)-1)) {
            swap(i , arr.length - i-1, arr);
            return;
        }
        rev(arr, i + 1);
        swap(i , arr.length - i-1, arr);
    }

    void rev2(int arr[], int i) {
        if (i >= arr.length / 2) {
            return;
        }
        swap(i, arr.length - i - 1, arr);
        rev2(arr, i + 1);

    }

    void swap(int i, int j, int[] arr) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        ReverseArrayUsingRec reverseArrayUsingRec = new ReverseArrayUsingRec();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6,7};
        reverseArrayUsingRec.rev(arr, 0);
        System.out.println(Arrays.toString(arr));
//        reverseArrayUsingRec.rev2(arr, 0);
//        System.out.println(Arrays.toString(arr));

    }
}
