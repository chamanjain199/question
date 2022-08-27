package geeksForGeeks.bitmanipulation;

import java.util.Arrays;

public class SumOftTwoNumbers {
    static int sum(int a, int b) {
        while (b != 0) {
            int tem = (a & b) << 1;
            a = a ^ b;
            b = tem;
        }
        Arrays.asList(a,b);
        return a;
    }

    public static void main(String[] args) {
        System.out.println(sum(6, 6));
    }
}
