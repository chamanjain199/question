package revision.bitmanipulation;

import java.util.Arrays;

public class SumOftTwoNumbers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }

    static int sum2(int a, int b) {
        int carry = 0;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bitia = 1 & (a >> i);
            int bitib = 1 & (b >> i);
            int temp = 0;
            if (bitia == 1 && bitib == 1) {
                if (carry == 1) {
                    temp = 1;
                } else {
                    temp = 0;
                }
                carry = 1;
            } else if (bitia == 0 && bitib == 0) {
                temp = carry;
                carry = 0;
            } else {
                if (carry == 1) {
                    temp = 0;
                    carry = 1;
                } else {
                    temp = 1;
                    carry = 0;
                }
            }
            ans |= (temp << i);

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(sum2(5, 5));
    }

}
