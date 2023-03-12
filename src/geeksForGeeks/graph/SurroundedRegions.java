package geeksForGeeks.graph;

public class SurroundedRegions {

    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        int[] rows = new int[]{0, 0, 1, -1};
        int[] cols = new int[]{1, -1, 0, 0};
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, rows, cols, visited, board, row, col);
            }
            if (board[i][col - 1] == 'O') {
                dfs(i, col - 1, rows, cols, visited, board, row, col);
            }
        }
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, rows, cols, visited, board, row, col);
            }
            if (board[row - 1][i] == 'O') {
                dfs(row - 1, i, rows, cols, visited, board, row, col);
            }
        }
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(int row, int col, int[] rows, int[] cols, boolean[][] visited, char[][] board, int totalRow, int totalCol) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 4; k++) {
                if ((row + rows[k]) > -1
                        && (col + cols[k]) > -1
                        && (row + rows[k]) < totalRow && (col + cols[k]) < totalCol
                        && !visited[row + rows[k]][col + cols[k]]
                        && board[row + rows[k]][col + cols[k]] == 'O') {
                    dfs(row + rows[k], col + cols[k], rows, cols, visited, board, totalRow, totalCol);
                }
            }
        }
    }
}
