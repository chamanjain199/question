package geeksForGeeks.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Box {
    int i;
    int j;

    public Box(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int maxRow = image.length - 1;
        int maxCol = image[0].length - 1;
        Queue<Box> queue = new LinkedList<>();
        int oldColor = image[sr][sc];
        queue.add(new Box(sr, sc));

        if (color == oldColor) {
            return image;
        }
        while (!queue.isEmpty()) {
            Box curBox = queue.poll();
            int i = curBox.i;
            int j = curBox.j;
            image[i][j] = color;
            if (i < maxRow && image[i + 1][j] == oldColor) {
                queue.add(new Box(i + 1, j));
            }
            if (i > 0 && image[i - 1][j] == oldColor) {
                queue.add(new Box(i - 1, j));
            }
            if (j < maxCol && image[i][j + 1] == oldColor) {
                queue.add(new Box(i, j + 1));
            }
            if (j > 0 && image[i][j - 1] == oldColor) {
                queue.add(new Box(i, j - 1));
            }
        }
        return image;
    }

    public static int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int maxRow = image.length - 1;
        int maxCol = image[0].length - 1;
        int oldColor = image[sr][sc];
        if (color == oldColor) {
            return image;
        }
        dfs(image, sr, sc, color, oldColor, maxRow, maxCol);
        return image;
    }

    public static void dfs(int[][] image, int i, int j, int newColor, int oldColor, int maxRow, int maxCol) {

        image[i][j] = newColor;

        if (i < maxRow && image[i + 1][j] == oldColor) {
            dfs(image, i + 1, j, newColor, oldColor, maxRow, maxCol);
        }
        if (i > 0 && image[i - 1][j] == oldColor) {
            dfs(image, i - 1, j, newColor, oldColor, maxRow, maxCol);
        }
        if (j < maxCol && image[i][j + 1] == oldColor) {
            dfs(image, i, j + 1, newColor, oldColor, maxRow, maxCol);
        }
        if (j > 0 && image[i][j - 1] == oldColor) {
            dfs(image, i, j - 1, newColor, oldColor, maxRow, maxCol);
        }

    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0)));
    }
}
