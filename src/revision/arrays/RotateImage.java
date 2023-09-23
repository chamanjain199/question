package revision.arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            rotateUtil(matrix[i], 0, len - 1);
        }

    }

    public void rotateUtil(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }

    public void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {

    }

}
