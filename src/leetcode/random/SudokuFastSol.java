package leetcode.random;

public class SudokuFastSol {
    private int available[][];
    private int rows[];
    private int cols[];
    private int sqs[];
    private int  ALL_ON = (1<<9) - 1;
    private int lookup[];
    private boolean found;
    private int aplace;
    private boolean doneOnce= false;

    private int getFastest(int start) {
        int fastest = -1;
        int minSet = 10;
        for(int i=start;i<aplace;i++) {
            int r = available[i][0];
            int c = available[i][1];

            int avail = rows[r] & cols[c] & sqs[(r/3)*3 + (c/3)];
            if (avail == 0) return -1;

            int numSet = Integer.bitCount(avail);
            //System.out.println("i = " +i + " numSet= " + numSet);
            if (numSet == 1) return i;
            if (numSet < minSet) {
                minSet = numSet;
                fastest = i;
            }
        }
        return fastest;
    }
    private void swapCells(int i, int j) {
        int a = available[i][0];
        int b = available[i][1];

        available[i][0] = available[j][0];
        available[i][1] = available[j][1];

        available[j][0] = a;
        available[j][1] = b;
    }
    public void solve(int depth,char board[][] ) {
        if(found) return;
        if (depth == aplace) {
            found = true;
            return;
        }
        //find most constrained
        int fastest = getFastest(depth);
        //System.out.println("depth " + depth + " fastest " +fastest);
        if (fastest == -1) return;

        swapCells(depth, fastest);

        int row = available[depth][0];
        int col = available[depth][1];

        int t = (row/3) * 3 + (col/3);

        int res = rows[row] & cols[col] & sqs[t];

        while (res != 0) {
            int lsb = (res & -res);
            char toAdd = (char)(lookup[lsb] + '1');
            //System.out.println("row " + row + " col " + col + " " + toAdd);

            rows[row] ^= lsb;
            cols[col] ^= lsb;
            sqs[t] ^= lsb;

            board[row][col] = toAdd;

            solve(depth+1, board);
            if (found) return;

            rows[row] ^= lsb;
            cols[col] ^= lsb;
            sqs[t] ^= lsb;

            res ^= lsb;
        }

    }
    public void solveSudoku(char board[][]) {
        if (!doneOnce){
            available = new int[80][2];
            lookup = new int [(1<<(board.length))];
            rows = new int [board.length];
            cols = new int [board[0].length];

            sqs = new int[9];
        }
        doneOnce = true;

        found = false;
        aplace = 0;

        for(int i=0;i<board.length;i++) {
            rows[i] = ALL_ON;
            cols[i] = ALL_ON;
            lookup[(1<<i)] = i;
            sqs[i] = ALL_ON;
        }

        for(int j=0;j<board[0].length;j++) {
            for(int i=0;i<board.length;i++) {
                if (board[i][j] == '.') {
                    int [] pair = new int[2];
                    pair[0] = i;
                    pair[1] = j;
                    available[aplace++] = pair;
                    //System.out.println(i+" "+ j);
                } else {
                    int num = board[i][j] - '1';
                    rows[i] ^= (1<<num);
                    cols[j] ^= (1<<num);

                    int ti = (i/3) * 3;
                    int tj = (j/3);
                    sqs[ti + tj] ^= (1<<num);
                }
            }
        }
        solve(0, board);
        //board = ans;
    }
}
