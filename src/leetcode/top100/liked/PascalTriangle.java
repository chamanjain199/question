package leetcode.top100.liked;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generateOld(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows >= 1) {
            result.add(List.of(1));
        }
        if (numRows >= 2) {
            result.add(List.of(1, 1));
        }
        if (numRows <= 2) {
            return result;
        }
        int i = 2;
        List<Integer> pre = result.get(1);
        for (; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(i);
            int k = (i + 1) / 2;
            if (i % 2 == 0) {
                k = k + 1;
            }
            for (int j = 2; j < k; j++) {
                list.add(pre.get(j) + pre.get(j - 1));
            }
            int l = i / 2;
            if (i % 2 == 0) {
                l = l - 1;
            }
            for (int j = l; j > -1; j--) {
                list.add(list.get(j));
            }
            result.add(list);
            pre = list;
        }

        return result;
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(List.of(1));
        int i = 1;
        List<Integer> pre = result.get(0);
        for (; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);

            for (int j = 1; j < i; j++) {
                list.add(pre.get(j) + pre.get(j - 1));
            }
            list.add(1);

            result.add(list);
            pre = list;
        }

        return result;
    }


    public static void main(String[] args) {

        System.out.println(generate(12));

    }
}
