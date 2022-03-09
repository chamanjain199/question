package geeksForGeeks;

public class ArrayIsRotatedAndSorted {
    public static boolean checkRotatedAndSorted(int arr[], int num) {

        int positiveCount = 0;
        int negativeCount = 0;

        for (int i = 0; i < num - 1; i++) {

            if (arr[i] - arr[i + 1] >= 0) {
                positiveCount++;
            } else {
                negativeCount++;
            }
        }
        if (arr[0] - arr[num - 1] >= 0) {
            positiveCount++;
        } else {
            negativeCount++;
        }


        return (positiveCount==2 || negativeCount==2);

    }

    public static void main(String[] args) {

        checkRotatedAndSorted(new int[]{7,8,3}, 4);
    }
}
