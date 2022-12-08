package geeksForGeeks.stack;

class TwoStack {

    int size;
    int top1, top2;
    int arr[] = new int[100];

    TwoStack() {
        size = 100;
        top1 = -1;
        top2 = size;
    }
}

public class ImplementTwoStackInSingleArray {
    //Function to push an integer into the stack1.
    void push1(int x, TwoStack sq) {
        if (!isFull(sq)) {
            sq.arr[++sq.top1] = x;
        }
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq) {
        if (!isFull(sq)) {
            sq.arr[--sq.top2] = x;
        }
    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq) {

        if (!isEmpty1(sq)) {
            return sq.arr[sq.top1--];
        }
        return -1;

    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq) {
        if (!isEmpty2(sq)) {
            return sq.arr[sq.top2++];
        }
        return -1;
    }

    boolean isEmpty1(TwoStack sq) {
        return sq.top1 == -1;
    }

    boolean isEmpty2(TwoStack sq) {
        return sq.top2 == sq.size;
    }

    boolean isFull(TwoStack sq) {
        return (sq.top2 - 1) == sq.top1;
    }

}
