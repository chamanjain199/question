package geeksForGeeks.searching;

import java.awt.*;
import java.util.Objects;

public class CountOnlyRepeated {
    public static Point findRepeating(Integer arr[], int n) {
        int low = 0;
        int high = n - 1;
        int mid;
        int repeated = -1;
        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] == (mid + 1)) {

                low = mid + 1;
            } else {
                repeated = high;
                high = mid - 1;
            }
        }
        if (repeated == -1)
            return new Point(repeated, -1);
        low = 0;
        high = n - 1;
        int lastIndex = 0;
        while (low <= high) {
            mid = (low + (high - low) / 2);
            if (arr[mid] == repeated) {
                lastIndex = mid;
                if (mid == n - 1 || !Objects.equals(arr[mid], arr[mid + 1])) {
                    break;
                }
                low = mid + 1;
            } else if (arr[mid] > repeated) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        int firstIndex = repeated - 1;
        return new Point(repeated, (lastIndex - firstIndex + 1));
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.println(findRepeating(arr, arr.length));
    }
}
