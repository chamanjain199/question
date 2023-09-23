package revision.recustion;

public class NQueueProblem {
    int count = 0;
    boolean[] d1;
    boolean[] d2;
    boolean[] column;
    boolean[][] board;

    public int totalNQueens(int n) {
        d1 = new boolean[2 * n - 1];
        d2 = new boolean[2 * n - 1];
        column = new boolean[n];
        board = new boolean[n][n];
        helper(n, 0);
        return count;
    }
    //n + row - col-1
    //row -col  basic logic
    // adding n to get positive index
    // doing -1 because n is not following 0 based indexing

    private void helper(int n, int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!column[col] && !d1[row + col] && !d2[n + row - col - 1]) {
                board[row][col] = true;
                column[col] = true;
                d1[row + col] = true;
                d2[n + row - col - 1] = true;
                helper(n, row + 1);
                board[row][col] = false;
                column[col] = false;
                d1[row + col] = false;
                d2[n + row - col - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        NQueueProblem nQueueProblem = new NQueueProblem();
        System.out.println(nQueueProblem.totalNQueens(8));
    }
}
