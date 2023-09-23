package geeksForGeeks.arrays;

public class SmallestPositiveMissingNumber {
    static int missingNumber(int arr[], int size) {
        int tempArray[] = new int[size];
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                if (arr[i] <= size)
                    tempArray[arr[i] - 1]++;
            }
        }
        for (int i = 0; i < size; i++) {
            if (tempArray[i] == 0) {
                return i + 1;
            }
        }
        return size + 1;

    }

    //Function to find the smallest positive number missing from the array.
    //arr[i] == arr[arr[i] - 1] to avoid duplicate for ex (1 ,1,1,1)
    // if first 1 is already moved to its position, then other 1, we can check if they are already  moved to their position
    static int missingNumber2(int arr[], int size) {
        for (int i = 0; i < size; ) {
            if (arr[i] > 0 && arr[i] < size &&  arr[i] != arr[arr[i] - 1]) {
                swap( i, arr[i] - 1,arr);
            } else {
                i++;
            }
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] != (i + 1)) {
                return (i + 1);
            }
        }
        return size + 1;
    }

    public static void swap(int i, int j, int arr[]) {
        int temp = arr[i - 1];
        arr[i - 1] = i;
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber2(new int[]{1, 1}, 2));
    }
}
