package geeksForGeeks.arrays;

public class SecondMaxElement {
    public static int secondMax(int[] arr) {
        int fIndex = 0;
        int secondIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[fIndex]) {
                secondIndex = fIndex;
                fIndex = i;
            } else if (arr[i] != arr[fIndex]) {
                if (secondIndex > -1 && arr[i] > arr[secondIndex])
                    secondIndex = i;
            }
        }
        return secondIndex;
    }
    int print2largest(int arr[], int n) {
        int firstLargest = -1;
        int secondLargest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != firstLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
    public static void main(String[] args) {
        System.out.println(secondMax(new int[]{5, 20, 12, 20, 8}));
    }
}
