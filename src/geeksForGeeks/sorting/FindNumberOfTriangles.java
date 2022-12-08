package geeksForGeeks.sorting;

import java.util.Arrays;

public class FindNumberOfTriangles {
    static int findNumberOfTrianglesTLE(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int x = arr[i];
            for (int j = i + 1; j < n - 1; j++) {

                int y = arr[j];

                for (int k = j + 1; k < n; k++) {
                    if ((x + y) > arr[k]) {
                        count += 1;

                    }
                }
            }
        }
        return count;

    }

    static int findNumberOfTriangles(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int x = arr[i];
            for (int j = i + 1; j < n - 1; j++) {
                int y = arr[j];
                if ((x + y) > arr[n - 1]) {
                    count += (n - j - 1);
                } else
                    for (int k = j + 1; k < n; k++) {
                        if ((x + y) <= arr[k]) {
                            count += (k - j - 1);
                            break;
                        }
                    }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{22, 11, 21, 5, 1, 17, 8, 1, 10, 10};
        System.out.println(":::: " + findNumberOfTrianglesTLE(arr, arr.length));
        System.out.println(":::: " + findNumberOfTriangles(arr, arr.length));
    }
}
