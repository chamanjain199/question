package leetcode.daily.challenge;

public class NumberOfStepsToReduceANumberToZero {
    public static int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
            if (num > 0)
                count++;
        }
        return count;
    }

    public int numberOfSteps1(int num) {
          int count = 0;
         while (num > 0) {
             if ((num & 1) == 0) {
                 num /= 2;
             } else {
                 num = num - 1;
             }
             count++;
         }
         return count;

    }
    public static void main(String[] args) {
        System.out.println(numberOfSteps((int) Math.pow(10, 6)));
    }
}
