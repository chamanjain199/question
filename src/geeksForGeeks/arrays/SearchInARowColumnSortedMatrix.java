package geeksForGeeks.arrays;

public class SearchInARowColumnSortedMatrix {
    static boolean search(int matrix[][], int n, int m, int x) {
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            int num = matrix[i][j];
            if (num == x) {
                return true;
            }
            if (num < x) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = (n * m)-1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            int numAtMid = matrix[mid / m][mid % m];
            if (numAtMid == target) {
                return true;
            }
            if (target > numAtMid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        boolean found = searchMatrix(matrix,  30);
        System.out.println(found);
    }
}
