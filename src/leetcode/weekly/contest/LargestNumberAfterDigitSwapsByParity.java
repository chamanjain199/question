package leetcode.weekly.contest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNumberAfterDigitSwapsByParity {

    public static int largestInteger(int num) {

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        int tmp = num;
        while (tmp > 0) {
            odd.add(tmp % 10);
            tmp = tmp / 100;
        }
        tmp = num;
        tmp = tmp / 10;
        while (tmp > 0) {
            even.add(tmp % 10);
            tmp = tmp / 100;
        }
        odd.sort(Comparator.reverseOrder());
        even.sort(Comparator.reverseOrder());
        int nu = 0;
        int oddSize = 0;
        int evenSize = 0;


        while (oddSize < odd.size() && evenSize < even.size()) {

                if (odd.size() > even.size()) {
                    nu = nu * 10 + odd.get(oddSize++);
                    nu = nu * 10 + even.get(evenSize++);
                } else {
                    nu = nu * 10 + even.get(evenSize++);
                    nu = nu * 10 + odd.get(oddSize++);
                }

        }
        while (oddSize < odd.size()) {
            nu = nu * 10 + odd.get(oddSize++);

        }
        while (evenSize < even.size()) {
            nu = nu * 10 + even.get(evenSize++);

        }
        return nu;
    }

    public static void main(String[] args) {

        System.out.println(largestInteger(247));
    }
}
