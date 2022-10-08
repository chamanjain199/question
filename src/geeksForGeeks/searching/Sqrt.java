package geeksForGeeks.searching;

public class Sqrt {
    public static int mySqrt(int x) {
        long low = 1;
        long high = x / 2;
        long mid = 0;

        while (low <= high) {
             mid = (low + high) / 2;
            long avg=mid*mid;
            if (avg == x) {
                return (int) mid;
            }
            if (avg > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (high * high > x) {
            return (int) high - 1;
        }


        return (int) high;


    }

    public static void main(String[] args) {
        System.out.println("Sqrt of " + 8 + " " + (mySqrt(4)));


    }
}
