package revision.tree;

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
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows = image.length;
        int cols = image[0].length;
        int startingColor = image[sr][sc];
        if (color == startingColor) {
            return image;
        }
        Queue<Box> queue = new LinkedList<>();
        queue.add(new Box(sr, sc));

        while (!queue.isEmpty()) {
            Box box = queue.poll();
            image[box.i][box.j] = color;
            if (box.i > 0 && image[box.i - 1][box.j] == startingColor) {
                queue.add(new Box(box.i - 1, box.j));
            }
            if (box.i < rows - 1 && image[box.i + 1][box.j] == startingColor) {
                queue.add(new Box(box.i + 1, box.j));
            }
            if (box.j > 0 && image[box.i][box.j - 1] == startingColor) {
                queue.add(new Box(box.i, box.j - 1));
            }
            if (box.j < cols - 1 && image[box.i][box.j + 1] == startingColor) {
                queue.add(new Box(box.i, box.j + 1));
            }
        }
        return image;

    }
}
