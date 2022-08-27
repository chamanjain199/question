package leetcode;

import java.util.ArrayList;

//https://www.youtube.com/watch?v=yvt0emtFiIE&t=1282s
public class NQueue {

    int count=0;
    boolean[] blockedRow;
    boolean[] diagonal1;
    boolean[] diagonal2;

     int nQueen(int n) {

        blockedRow = new boolean[n];
        diagonal1 = new boolean[2*n];
        diagonal2 = new boolean[2*n];
        solution1(n, 0);
        return count;
    }

    public void solution1(int n, int col) {
        if (col == n) {
            count++;
        }
        for (int i = 0; i < n; i++) {
            if (isSafeForQueuen(col, i, n)) {
                blockedRow[i] = true;
                diagonal1[(i + col)] = true;
                diagonal2[(n + i - col)] = true;
                solution1(n, col + 1);
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
    public static void main(String[] args) {

        System.out.println(new NQueue().nQueen(4));

    }
}
