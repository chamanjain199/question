package leetcode.biweekly.contest;

public class NumberofWaystoSelectBuildings {
    public static long numberOfWays(String s) {
        char[] tochar = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(tochar[0]);
        for (int i = 1; i < s.length(); i++) {
            if (tochar[i - 1] != tochar[i]) {
                sb.append(tochar[i]);
            }
        }
        if (sb.length() < 3) {
            return 0;
        } else {
            System.out.println(sb);
            int diff = sb.length() - 3;
            return 3L * (diff + 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(numberOfWays("0001100100"));
    }
}
