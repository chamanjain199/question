package geeksForGeeks.mathematics;

import java.util.ArrayList;

public class QuadraticEquationRoots {
    public ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> roots = new ArrayList<>();
        double discriminant = b*b - 4*a*c;
        if (discriminant < 0) {
            roots.add(-1);
        } else {
            double sqrt=Math.sqrt(discriminant);
            double x1 = (-b + sqrt) / (2 * a);
            double x2 =  (-b - sqrt) / (2 * a);
            roots.add((int) Math.floor(Math.max(x1, x2)));
            roots.add((int) Math.floor(Math.min(x1, x2)));
        }
        return roots;
    }

    public static void main(String[] args) {

    }
}
