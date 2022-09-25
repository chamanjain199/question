package self.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {
    List<int[][]> allSolutions = new ArrayList<>();

    public void solveSudoku(int[][] grid) {
        solve(grid, 0, 0);
    }

    public void solve(int[][] grid, int row, int column) {

        if (column == grid.length) {
            row = row + 1;
            column = 0;
        }
        if (row == grid.length) {
            solvePrint(grid,0,0);
            return;
        }
        if (grid[row][column] == 0) {
            for (int i = 1; i <= 9; i++) {

                if (isValid(grid, row, column, i)) {
                    grid[row][column]=i;
                    solve(grid, row, column + 1);
                    grid[row][column]=0;
                }
            }
        } else {
            solve(grid, row, column + 1);
        }

    }
    public void solvePrint(int[][] board, int row, int column) {
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

    private static boolean isValid(int[][] grid, int row, int column, int number) {
        for (int i = 0; i <= 8; i++) {
            if (grid[row][i] == number) {
                return false;
            }
            if (grid[i][column] == number) {
                return false;
            }
        }
        int boxi = row / 3;
        boxi=boxi*3;
        int boxj = column / 3;
        boxj=boxj*3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[boxi + i][boxj + j] == number) {
                    return false;
                }
            }
        }


        return true;

    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
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
