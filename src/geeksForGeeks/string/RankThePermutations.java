package geeksForGeeks.string;

public class RankThePermutations {
    public static long findRank(String S) {
        long permutation = 1L;
        int len = S.length();
        int[] countArr = new int[26];
        for (int i = 0; i < len; i++) {
            permutation *= (i + 1);
            countArr[S.charAt(i) - 'a']++;
        }
        for (int i = 1; i < 26; i++) {
            countArr[i] += countArr[i - 1];
        }
        long rank=1L;
        for (int i = 0; i < len-1; i++) {
            int idx=S.charAt(i) - 'a';
            int co=countArr[idx];
            permutation = permutation / (len - i );
            rank+=permutation*(co-1);
            for (int j = idx; j < 26; j++) {
                countArr[j]--;
            }
        }
        return rank;
    }

    public static void main(String[] args) {
        System.out.println(findRank("string"));
    }
}
