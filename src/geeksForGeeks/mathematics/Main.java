package geeksForGeeks.mathematics;

import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~
    private static void allPrimeFromZeroTo(int target, List<Integer> integers) {
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

    public static void segmentedSieveAlgo(int L, int R) {
        StringBuilder sb = new StringBuilder();
        int rootb = (int) Math.sqrt(R);
        ArrayList<Integer> primes = new ArrayList<>();
        allPrimeFromZeroTo(rootb, primes);

        int count = 0;
        boolean bool[] = new boolean[R - L + 1];
        for (int prime :
                primes) {
            int multiple = (int) Math.ceil(L * 1.0 / prime);
            if (multiple == 1) {
                multiple++;
            }
            int index = (multiple * prime) - L;
            for (int i = index; i < bool.length; i += prime) {
                bool[i] = true;
            }
        }
        for (int i = 0; i < bool.length; i++) {
            if(!bool[i] && i+L!=1){
                count++;
            }
        }
        System.out.println(count);

        //return count;

//        for (int i : primes) {
//            int multiple = (int) Math.ceil(a * 1.0 / i);
//            if (multiple == 1) {
//                multiple++;
//            }
//            int firstidx = (multiple * i) - a;
//            while (firstidx < arr.length) {
//                arr[firstidx] = true;
//                firstidx += i;
//            }
//
//        }
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == false && (a + i) != 1) {
//                count++;
//                sb.append(a + i + "\n");
//            }
//        }
        System.out.println(" -------------------");
        System.out.println(count);
//    sb.append("\n");
//    System.out.println(sb);
    }

    // ~~~~~~~~~~~~Input Management~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        segmentedSieveAlgo(1, 10000);
    }
}

                                
                                