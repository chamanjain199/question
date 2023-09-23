package revision.arrays;

public class SecondMaxElement {
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
}
