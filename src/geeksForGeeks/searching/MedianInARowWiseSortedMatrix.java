package geeksForGeeks.searching;

public class MedianInARowWiseSortedMatrix {
    static int median(int matrix[][], int r, int c) {
        int midPoint = (r * c + 1) >> 1;
        int min = matrix[0][0];
        int max = matrix[r - 1][c - 1];
        for (int i = 0; i < r; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][c - 1]);
        }
        int low = min;
        int high = max;
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            int count = 0;
            for (int i = 0; i < r; i++) {
                count += countInRow(matrix[i], mid);
            }

            if (count < midPoint) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;

    }

    private static int countInRow(int arr[], int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (arr[mid] <= num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }


    public static void main(String[] args) {

        System.out.println(median(new int[][]{{1, 2, 13}}, 1, 3));
    }
}
