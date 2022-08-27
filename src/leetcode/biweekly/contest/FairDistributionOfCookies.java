package leetcode.biweekly.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.IntStream;

public class FairDistributionOfCookies { //now working
    static List<Integer> keeing = new ArrayList<>();
    static int diff = Integer.MAX_VALUE;
    static BitSet bs=new BitSet();

    private static void rec(List<Integer> list, int avg, int index, int sumUpTo, List<Integer> contribution) {
        if(index== list.size()){
            return;
        }
        if (Math.abs(avg - sumUpTo)<diff && !contribution.isEmpty()) {
            diff = Math.abs(avg - sumUpTo);
            keeing = new ArrayList<>(contribution);
        }
        for (int i = 0; i < list.size(); i++) {
            if(bs.get(i)){
                continue;
            }
            bs.set(i);
            int bag = list.get(i);
            if (bag == 0) {
                continue;
            }
            sumUpTo += bag;
            contribution.add(bag);
            rec(list, avg, index + 1, sumUpTo, contribution);
            contribution.remove(contribution.size() - 1);
            bs.set(i,false);
        }

    }

    public static int distributeCookies(int[] cookies, int k) {
        IntStream stream = Arrays.stream(cookies);
        List<Integer> list = new ArrayList<>(stream.boxed().toList());
        int sum = Arrays.stream(cookies).sum();
        int avg = sum / k;
        int arr[] = new int[k];
        diff=sum;
        for (int i = 0; i < k; i++) {
            rec(list, avg, 0, 0, new ArrayList<>());
            arr[i] = keeing.stream().mapToInt(Integer::intValue).sum();

            System.out.println(keeing);
            list.removeAll(keeing);
            diff=list.stream().mapToInt(Integer::intValue).sum();;
            keeing.clear();
        }
        int max = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(distributeCookies(new int[]{8,15,10,20,8},2));
    }
}
