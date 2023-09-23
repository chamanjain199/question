package revision.arrays;

public class SearchInARowColumnSortedMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {

            int curEle = matrix[i][j];
            if (curEle == target) {
                return true;
            }
            if (target > curEle) {
                i++;
            } else {
                j--;
            }
        }
        return false;

    }
}
