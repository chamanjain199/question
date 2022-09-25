package self.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueueProblem {
    List<List<String>> finalAns = new ArrayList<>();
    char[][] chessBoard;
    boolean[] blockedCol;
    boolean[] diagonal1;
    boolean[] diagonal2;

    public List<List<String>> placeNQueue(int n) {
        chessBoard = new char[n][n];
        blockedCol = new boolean[n];
        diagonal2 = new boolean[n * 2];
        diagonal1 = new boolean[n * 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessBoard[i], '_');
        }
        solveNQueue(3, 0);
        return finalAns;
    }

    private void solveNQueue(int n, int row) {
        if (row == n) {
            List<String> singleSolution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                singleSolution.add(new String(chessBoard[i]));
            }
            finalAns.add(singleSolution);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafeToPlace(col, row, n)) {
                chessBoard[row][col] = 'Q';
                blockedCol[col] = true;
                diagonal1[row + col] = true;
                diagonal2[n + col - row] = true;
                solveNQueue(n, row + 1);
                chessBoard[row][col] = '_';
                blockedCol[col] = false;
                diagonal1[row + col] = false;
                diagonal2[n + col - row] = false;
            }

        }
    }

    private boolean isSafeToPlace(int col, int row, int n) {
        if (blockedCol[col]) {
            return false;
        }
        if (diagonal1[row + col]) {
            return false;
        }
        if (diagonal2[n + row - col]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueueProblem nQueueProblem = new NQueueProblem();
        System.out.println(nQueueProblem.placeNQueue(3));
    }
}
