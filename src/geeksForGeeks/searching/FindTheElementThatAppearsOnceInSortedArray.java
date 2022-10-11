package geeksForGeeks.searching;

public class FindTheElementThatAppearsOnceInSortedArray {
    static int findOnce(int arr[], int n) {
        if (n == 1) {
            return arr[0];
        }
        int low = 0;
        int high = n - 1;
        int mid;
        int ans = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (mid == 0 && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }
            if (mid == n - 1 && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }
            if ((mid & 1) == 0) {
                if (arr[mid] == arr[mid + 1]) {
                    low = mid + 1;
                } else if (arr[mid] == arr[mid - 1]) {
                    high = mid - 1;
                }
            } else {
                if (arr[mid] == arr[mid - 1]) {
                    low = mid + 1;
                } else if (arr[mid] == arr[mid + 1]) {
                    high = mid - 1;
                }
            }
        }
        return ans;
    }

    static int findOnce1(int arr[], int n) {
        int low = 0;
        int high = n - 2;
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (arr[mid] == arr[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3};
        System.out.println(findOnce(arr, arr.length));
    }
}
