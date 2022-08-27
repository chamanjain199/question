package leetcode.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.youtube.com/watch?v=yvt0emtFiIE&t=1282s
public class NQueue {
    char[][] charboard;
    List<List<String>> finalAns = new ArrayList<>();
    boolean[] blockedRow;
    boolean[] diagonal1;
    boolean[] diagonal2;

    public List<List<String>> solveNQueens(int n) {
        blockedRow = new boolean[n];
        diagonal1 = new boolean[2*n];
        diagonal2 = new boolean[2*n];
        charboard = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            charboard[i] = row;
        }
        solution1(n, 0);
        return finalAns;
    }

    public void solution1(int n, int col) {
        if (col == n) {
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strings.add(new String(charboard[i]));
            }
            finalAns.add(strings);
        }
        for (int i = 0; i < n; i++) {
            if (isSafeForQueuen(col, i, n)) {
                blockedRow[i] = true;
                charboard[i][col] = 'Q';
                diagonal1[(i + col)] = true;
                diagonal2[(n + i - col)] = true;
                solution1(n, col + 1);
                charboard[i][col] = '.';
                diagonal1[(i + col)] = false;
                diagonal2[(n + i - col)] = false;
                blockedRow[i] = false;
            }
        }
    }

    private boolean isSafeForQueuen(int col, int row, int n) {
        if (blockedRow[row]) {
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
    //        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//            if (charboard[i][j] == 'Q') {
//                return false;
//            }
//        }
//        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
//            if (charboard[i][j] == 'Q') {
//                return false;
//            }
//        }

    public static void main(String[] args) {
        NQueue nQueue = new NQueue();
        nQueue.solveNQueens(4);
        System.out.println("total sol "+nQueue.finalAns.size());
        for (int i = 0; i < nQueue.finalAns.size(); i++) {
            System.out.println(nQueue.finalAns.get(i));
        }

    }
}
