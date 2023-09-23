package revision.arrays;

public class PrintFrequency {
    public static void printFrequency(int[] arr) {
        int len = arr.length;
        int freq = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                freq++;
            } else {
                System.out.println(arr[i - 1] + " " + freq);
                freq = 1;
            }
        }
        System.out.println(arr[len - 1] + " " + freq);
    }
}
