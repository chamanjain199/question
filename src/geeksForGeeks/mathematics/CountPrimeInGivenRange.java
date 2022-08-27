package geeksForGeeks.mathematics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPrimeInGivenRange {
    static int countPrimes(int L, int R) {
        int diff = R - L + 1;
        List<Integer> primes = new ArrayList<>();
        int rootR = (int) Math.sqrt(R);
        allPrimeFromZeroTo(rootR, primes);
        System.out.println(primes);
        int count2=diff;
        boolean bool[] = new boolean[diff];
        for (int prime :
                primes) {
            int multiple = (int) Math.ceil(L * 1.0 / prime);
            if (multiple == 1) {
                multiple++;
            }
            int index = (multiple * prime) - L;
            for (int i = index; i < diff; i += prime) {

                if(!bool[i]) {
                    bool[i] = true;
                    count2--;
                }
            }
        }

        if(L==1){
            count2--;
        }
        if(L==0){
            count2-=2;
        }

        return count2;
    }

    private static   void allPrimeFromZeroTo(int target, List<Integer> integers) {
        if (target < 2) {
            return;
        }
        boolean bool[] = new boolean[target + 1];
        integers.add(2);
        if (target == 2) {
            return;
        }
        for (int i = 3; i <= target; i += 2) {
            if (!bool[i]) {
                integers.add(i);
                for (int j = i * i, step = i << 1; j <= target; j += step) {
                    bool[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(1, 100000));
    }
}
