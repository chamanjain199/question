package geeksForGeeks.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfTheCircularGame {
    public static int findTheWinner(int n, int k) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        if (k == 1) {
            return n;
        }
        int r = n;
        int count = 0;
        for (int i = 1; i <= (n + 1) & r > 1; i++) {
            if (i == (n + 1)) {
                i = 1;
            }
            if (arr[i] != 0)
                count = count + 1;
            if (count == k) {
                count = 0;
                arr[i] = 0;
                r--;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] != 0) {
                return arr[i];
            }
        }
        return 0;

    }

    public static int findTheWinnerOp(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        if (k == 1) {
            return n;
        }
        int cur = 0;
        while (list.size() > 1) {
            cur = (cur + k - 1) % list.size();
            list.remove(cur);
        }
        return list.get(0);
    }

    public static int findTheWinnerOp1(int n, int k) {
        if(n==1){
            return 0;
        }
        int x=findTheWinnerOp1(n-1,k);
        return (x+k)%n;

    }

    //This is just a reverse recursion
    public static int findTheWinnerOp2(int n, int k) {//josephus problem leetcode
        int ans  = 0;
        for (int i = 2; i <=n; i++) {
            ans=(ans+k)%i;
        }
        return ans+1;
    }



    public static void main(String[] args) {
        //System.out.println(findTheWinnerOp(8, 8));
        System.out.println("ANS "+findTheWinnerOp2(8, 8));

    }
}
