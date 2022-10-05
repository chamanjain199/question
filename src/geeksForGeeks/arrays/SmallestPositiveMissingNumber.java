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

    static int missingNumber2(int arr[], int size) {

        for (int i = 0; i < size; ) {
            if (arr[i] > 0 && arr[i] <= size) {
                if (arr[i] != (i+1) ) {
                    if(arr[i] ==arr[arr[i]-1]){ // avoid duplicate numbers
                           arr[i]=0;
                           i++;
                    }
                    else swap(arr[i], i, arr);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        for (int i = 0; i < size; i++) {
            if (arr[i] != (i+1)) {
                return i+1 ;
            }
        }
        return size + 1;

    }

    public static void swap(int i, int j, int arr[]) {
        int temp = arr[i-1];
        arr[i-1] = i;
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber2(new int[]{1,1}, 2));
    }
}
