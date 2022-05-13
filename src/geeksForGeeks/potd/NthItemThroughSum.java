package geeksForGeeks.potd;

import java.util.*;
import java.util.stream.IntStream;

public class NthItemThroughSum {
    static int nthItem(int L1, int L2, int A[], int B[], int N) {
        if (N == (L1 * L2)) {
            return -1;
        }
        Set<Integer> ts = new HashSet<>();

        for (int i = 0; i < L1; i++) {
            for (int j = 0; j < L2; j++) {
                ts.add(A[i] + B[j]);
            }
        }
        if(N>=ts.size()){
            return -1;
        }
        List<Integer> list=new ArrayList<>(ts);
        Collections.sort(list);


        return list.get(N-1);


    }

    public static void main(String[] args) {

        System.out.println(nthItem(5, 4, new int[]{1, 3, 4, 8, 10}, new int[]{20, 22, 30, 40}, 4));
    }
}
