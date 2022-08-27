package leetcode.random;

import java.util.Arrays;
import java.util.HashSet;

public class SudokuSolver {


    boolean solved = false;

    public void solveSudoku(String[][] board) {
        solvePrint(board, 0, 0);
        solve(board, 0, 0);
        solvePrint(board, 0, 0);
    }

    public void solveSudoku(char[][] board) {
        solvePrint(board, 0, 0);
        solve(board, 0, 0);
        solvePrint(board, 0, 0);
    }

    public void solveSudoku(int[][] grid) {
        //   solvePrint(grid);
        solve(grid, 0, 0);
        solvePrint(grid);
    }

    public boolean isValid(String[][] board, int row, int column, String po) {
        for (int i = 0; i <= 8; i++) {
            if (board[row][i].equals(po) || board[i][column].equals(po)) {
                return false;
            }
        }
        int i = row / 3;
        i *= 3;

        int j = column / 3;
        j *= 3;

        for (int k = i; k < (i + 3); k++) {
            for (int l = j; l < (j + 3); l++) {
                if (board[k][l].equals(po)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve(String[][] board, int row, int column) {

        if (column == board.length) {
            column = 0;
            row = row + 1;
        }
        if (row == board.length) {
            solved = true;
            solvePrint(board, 0, 0);
            return true;
        }
        if (board[row][column].equals(".")) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(board, row, column, i + "")) { //loop complete hona mtln no valid value found , then call will back tracked to previous loop
                    board[row][column] = i + "";
                    solve(board, row, column + 1);
                    if (!solved) {
                        board[row][column] = ".";
                    }
                }
            }

        } else {
            solve(board, row, column + 1);
        }
        return false;
    }


    public void solvePrint(String[][] board, int row, int column) {
        if (column == board.length) {
            System.out.println();
            column = 0;
            row = row + 1;
        }
        if (row == board.length) {
            System.out.println("Reverse");
            return;
        }
        System.out.print("[" + board[row][column] + "]");

        solvePrint(board, row, column + 1);

    }

    public void solve(char[][] board, int row, int column) {

        if (column == board.length) {
            column = 0;
            row = row + 1;
        }
        if (row == board.length) {
            solved = true;
        }
        if (board[row][column] == '.') {
            for (int i = 0; i <= 8; i++) {
                if (isValid(board, row, column, (char) (48 + i))) { //loop complete hona mtln no valid value found , then call will back tracked to previous loop
                    board[row][column] = (char) (48 + i);
                    solve(board, row, column + 1);
                    if (!solved) {
                        board[row][column] = '.';
                    }
                }
            }

        } else {
            solve(board, row, column + 1);
        }

    }

    public boolean isValid(char[][] board, int row, int column, char po) {
        for (int i = 0; i <= 8; i++) {
            if (board[row][i] == po || board[i][column] == po) {
                return false;
            }
        }
        int i = row / 3;
        i *= 3;

        int j = column / 3;
        j *= 3;

        for (int k = i; k < (i + 3); k++) {
            for (int l = j; l < (j + 3); l++) {
                if (board[k][l] == po) {
                    return false;
                }
            }
        }

        return true;
    }

    public void solvePrint(char[][] board, int row, int column) {
        if (column == board.length) {
            System.out.println();
            column = 0;
            row = row + 1;
        }
        if (row == board.length) {
            System.out.println("Reverse");
            return;
        }
        System.out.print("[" + board[row][column] + "]");

        solvePrint(board, row, column + 1);

    }

    public void solve(int[][] board, int row, int column) {

        if (column == board.length) {
            column = 0;
            row = row + 1;
        }
        if (row == board.length) {
            solved = true;
            return;
        }
        if (board[row][column] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(board, row, column, i)) {
                    board[row][column] = i;
                    solve(board, row, column + 1);
                    if (!solved) {
                        board[row][column] = 0;
                    }
                }
            }

        } else {
            solve(board, row, column + 1);
        }

    }

    public boolean isValid(int[][] board, int row, int column, int po) {
        for (int i = 0; i <= 8; i++) {
            if (board[row][i] == po || board[i][column] == po) {
                return false;
            }
        }
        int i = row / 3;
        i *= 3;

        int j = column / 3;
        j *= 3;

        for (int k = i; k < (i + 3); k++) {
            for (int l = j; l < (j + 3); l++) {
                if (board[k][l] == po) {
                    return false;
                }
            }
        }
        return true;
    }

    public void solvePrint(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
//        sudokuSolver.solveSudoku(new String[][]{{".", ".", "9", "7", "4", "8", ".", ".", "."}
//                , {"7", ".", ".", ".", ".", ".", ".", ".", "."}, {".", "2", ".", "1", ".", "9", ".", ".", "."}
//                , {".", ".", "7", ".", ".", ".", "2", "4", "."},
//                {".", "6", "4", ".", "1", ".", "5", "9", "."}, {".", "9", "8", ".", ".", ".", "3", ".", "."}
//                , {".", ".", ".", "8", ".", "3", ".", "2", "."}, {".", ".", ".", ".", ".", ".", ".", ".", "6"},
//                {".", ".", ".", "2", "7", "5", "9", ".", "."}});

        sudokuSolver.solveSudoku(new int[][]{
                {6, 1, 4, 0, 0, 7, 0, 0, 0},
                {0, 0, 8, 0, 0, 0, 9, 0, 1},
                {0, 3, 0, 1, 2, 4, 0, 7, 0},
                {5, 0, 0, 8, 0, 0, 6, 0, 3},
                {0, 9, 2, 0, 0, 0, 1, 5, 0},
                {4, 0, 3, 0, 0, 5, 0, 0, 8},
                {0, 8, 0, 3, 9, 2, 0, 6, 0},
                {2, 0, 6, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 5, 0, 0, 2, 1, 7}});

    }
}
