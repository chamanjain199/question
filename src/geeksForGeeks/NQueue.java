package geeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=yvt0emtFiIE&t=1282s
public class NQueue {

    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
    ArrayList<Integer> subAns=new ArrayList<Integer>();
    boolean[] blockedRow;
    boolean[] diagonal1;
    boolean[] diagonal2;

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        NQueue sol=new NQueue();
        sol.blockedRow = new boolean[n];
        sol.diagonal1 = new boolean[2*n];
        sol.diagonal2 = new boolean[2*n];

        for (int i = 0; i < n; i++) {
            sol.subAns.add(0);
        }
        sol.solution1(n, 0);
        return sol.ans;
    }

    public void solution1(int n, int col) {
        if (col == n) {

            ans.add(new ArrayList<>(subAns));

        }
        for (int i = 0; i < n; i++) {
            if (isSafeForQueuen(col, i, n)) {
                blockedRow[i] = true;
                subAns.set(col,i+1);
                diagonal1[(i + col)] = true;
                diagonal2[(n + i - col)] = true;
                solution1(n, col + 1);
                subAns.set(col,0);
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

        System.out.println(nQueen(4));

    }
}
