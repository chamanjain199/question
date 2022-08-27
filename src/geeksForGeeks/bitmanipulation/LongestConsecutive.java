package geeksForGeeks.bitmanipulation;

public class LongestConsecutive {
    public static int maxConsecutiveOnes(int N) {

        int count = 0;
        int maxCount = 0;
        while (N> 0) {
            if ((N & 1) == 1) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                }
                count=0;
            }

            N >>= 1;
        }
        if (count > maxCount) {
            maxCount = count;
        }
       return maxCount;

    }
    public static void main(String[] args) {
        System.out.println(maxConsecutiveOnes(14));
    }
}
