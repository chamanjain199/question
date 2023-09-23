package geeksForGeeks.arrays;

public class PrintFrequency {
    public static void printFrequency(int[] arr) {
        int n = arr.length;
        int freq = 1;
        for (int i = 1; i <= n; i++) {
            while (i < n && arr[i] == arr[i - 1]) {
                freq++;
                i++;
            }
            System.out.println(arr[i - 1] + " " + freq);
            freq = 1;

        }
    }

    public static void main(String[] args) {
        printFrequency(new int[]{1,1,1,1,2,2});

        System.out.println();
    }
}
