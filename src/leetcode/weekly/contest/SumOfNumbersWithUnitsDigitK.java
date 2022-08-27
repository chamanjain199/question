package leetcode.weekly.contest;

public class SumOfNumbersWithUnitsDigitK {
    public static int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        if(num==k){
            return 1;
        }

        int diff = num - k;
        int multipleOfTen = 0;
        int count = 0;
        int halfNum=num/2;
        while (diff>0) {
            int lastDigit = diff % 10;
            if (lastDigit == k) {
                count++;
            }
            diff = num - (k+10 * (++multipleOfTen));

        }
        return count > 0 ? count : -1;

    }

    public static void main(String[] args) {
        System.out.println(minimumNumbers(10,5 ));
    }
}
