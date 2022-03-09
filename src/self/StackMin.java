package self;

public class StackMin {

    int arr[];
    int currentIndex = 0;
    int minimuns[];


    StackMin(int size) {
        arr = new int[size];
        minimuns = new int[size];
    }

    public int min() {
        return minimuns[currentIndex-1];
    }

    public void push(int val) {
        if (!isFull()) {
            arr[currentIndex] = val;
            if(isEmpty()){
                minimuns[currentIndex] =  val;

            }else{
                minimuns[currentIndex] = Math.min(minimuns[currentIndex-1], val);

            }
            currentIndex++;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return arr[--currentIndex];
        }
        return 0;
    }

    private boolean isEmpty() {
        return currentIndex == 0;
    }

    private boolean isFull() {
        return currentIndex == arr.length - 1;
    }

}
