package geeksForGeeks.searching;

public class NthRoot {
    public static int NthRoot(int n, int m) {

        int low = 1;
        int high = m;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            long temp = mid;
            for (int i = 1; i < n; i++) {
                temp *= mid;
                if (temp > m) {
                    break;
                }
            }
            if (temp == m) {
                return mid;
            } else if (temp > m) {
                high = mid - 1;
            } else {

                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(NthRoot(3, 126));
    }
}
