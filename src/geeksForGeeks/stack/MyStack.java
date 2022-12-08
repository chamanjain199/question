package geeksForGeeks.stack;

public class MyStack {
    int top;
    int arr[] = new int[1000];
    int size = 1000;

    MyStack() {
        top = -1;
    }

    //Function to push an integer into the stack.
    void push(int a) {
        if (top < (size - 1)) {
            top++;
            arr[top] = a;
        }
    }


    int pop() {
        if (top < 0) {
            return -1;
        }
        return arr[top--];
    }
}
