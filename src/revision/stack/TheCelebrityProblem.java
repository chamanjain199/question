package revision.stack;

import java.util.Arrays;
import java.util.Stack;

class Person {
    int heKnow;
    int otherKnowHim;

    Person(int heKnow, int otherKnowHim) {
        this.heKnow = heKnow;
        this.otherKnowHim = otherKnowHim;
    }

    @Override
    public String toString() {
        return "Person{" +
                "heKnow=" + heKnow +
                ", otherKnowHim=" + otherKnowHim +
                '}';
    }
}

public class TheCelebrityProblem {
    int celebrity(int M[][], int n) {
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(0, 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    people[i].heKnow++;
                    people[j].otherKnowHim++;
                }
            }
        }
        System.out.println(Arrays.toString(people));
        for (int i = 0; i < n; i++) {
            if (people[i].heKnow == 0 && people[i].otherKnowHim == n - 1) {
                return i;
            }
        }
        return -1;

    }

    int celebrityOptimized(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.add(i);
        }
        int p1;
        int p2;
        while (stack.size() != 1) {
            p1 = stack.pop();
            p2 = stack.pop();
            if (M[p1][p2] == 1) {
                stack.push(p2);
            } else {
                stack.push(p1);
            }
        }

        int celebrity = stack.pop();
        for (int i = 0; i < n; i++) {

            if (i!=celebrity && (M[celebrity][i] == 1 || M[i][celebrity] == 0)) {
                return -1;
            }
        }
        return celebrity;

    }
}
