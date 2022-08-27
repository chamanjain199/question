package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueueProblem {
    List<List<String>> results = new ArrayList<>();
    boolean blockedCols[];
    boolean blockedDiagonal1[];
    boolean blockedDiagonal2[];
    long count = 0;

    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        blockedCols = new boolean[n];
        blockedDiagonal1 = new boolean[2*n];
        blockedDiagonal2 = new boolean[2*n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chars[i], '.');
        }
        solveNQueensRec(results, chars, n, 0);

        return results;
    }

    public void solveNQueensRec(List<List<String>> lists, char[][] blocks, int n, int row) {

        if (n == row) {
            System.out.println(Arrays.deepToString(blocks));
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafeToPlace(blocks, row, col,n)) {
                blocks[row][col] = 'Q';
                blockedCols[col] = true;
                blockedDiagonal1[row + col] = true;
                blockedDiagonal2[n + row - col] = true;
                solveNQueensRec(lists, blocks, n, row + 1);
                blockedCols[col] = false;
                blockedDiagonal1[row + col] = false;
                blockedDiagonal2[n + row - col] = false;
                blocks[row][col] = '.';
            }
        }

    }

    private boolean isSafeToPlace(char[][] blocks, int row, int col,int n) {
//        for (int i = row - 1; i >= 0; i--) {
//            if (blocks[i][col] == 'Q') {
//                return false;
//            }
//        }
        if (blockedCols[col]) {
            return false;
        }

//        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//            if (blocks[i][j] == 'Q') {
//                return false;
//            }
//        }
        if (blockedDiagonal1[row+col]) {
            return false;
        }
//        for (int i = row - 1, j = col + 1; j < blocks.length && i >= 0; i--, j++) {
//            if (blocks[i][j] == 'Q') {
//                return false;
//            }
//        }
        if (blockedDiagonal2[n+row-col]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueueProblem obj = new NQueueProblem();
        obj.solveNQueens(8);
        System.out.println(obj.count);
    }
}
