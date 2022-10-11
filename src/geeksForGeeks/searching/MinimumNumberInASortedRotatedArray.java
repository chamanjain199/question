package geeksForGeeks.searching;

public class MinimumNumberInASortedRotatedArray {
    static int minNumber(int arr[], int low, int high) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (low == high) {
            return arr[low];
        }

        int mid = (low + high) / 2;
        if (arr[low] > arr[mid]) {
            high = mid - 1;
        } else if (arr[high] < arr[mid]) {
            low = mid + 1;
        } else if (arr[low] < arr[mid]) {
            high = mid - 1;
        }
        if (mid == low && arr[mid] < arr[mid + 1] && arr[mid] < arr[high]) {
            return arr[mid];
        }
        if (mid == high && arr[mid] < arr[low] && arr[mid] < arr[mid - 1]) {
            return arr[mid];
        }
        if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
            return arr[mid];
        }
        return minNumber(arr, low, high);

    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(minNumber(arr, 0, arr.length-1));

    }
}
