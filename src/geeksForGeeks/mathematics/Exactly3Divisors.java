package geeksForGeeks.mathematics;

import java.util.List;

public class Exactly3Divisors {

    public static int exactly3Divisors(int N) {
        int count = 2;
        if(N<=3){
            return 0;
        }
        if(N<8){
            return 1;
        }

        if(N<24){
            return 2;
        }

        for (int i = 5; i*i<= N; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }


    public static boolean isPrime(int N) {

        if(N%2==0||N%3==0)
            return false;
        for(int i=5;i*i<=N;i=i+6)
        {
            if(N%i==0||N%(i+2)==0)
                return false;
        }
        return true;

    }


    public static void main(String[] args) {
        System.out.println(exactly3Divisors(67));
    }
}
