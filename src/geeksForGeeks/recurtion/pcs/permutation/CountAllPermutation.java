package geeksForGeeks.recurtion.pcs.permutation;

import java.util.ArrayList;
import java.util.List;

public class CountAllPermutation {
    public long countAllPermutation(int N) {
        boolean[] flag = new boolean[N];
        System.out.println(helper(N, 0, flag));
        System.out.println(helperWithSwap(N, 0));
        return 0;
    }

    private long helper(int size, int index, boolean[] flag) {
        if (index == size) {
            return 1L;
        }
        long count = 0;
        for (int i = 0; i < size; i++) {
            if (!flag[i]) {
                flag[i] = true;
                count += helper(size, index + 1, flag);
                flag[i] = false;
            }
        }
        return count;
    }

    private long helperWithSwap(int size, int index) {

        if (index == size) {
            return 1L;
        }
        long count = 0;
        for (int i = index; i < size; i++) {

            count += helperWithSwap(size, index + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        CountAllPermutation countAllPermutation = new CountAllPermutation();
        System.out.println(countAllPermutation.countAllPermutation(8
        ));
    }
}
