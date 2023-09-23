package revision.string;

public class RankThePermutations {
    static int mod=1000003;
    static int rank(String S){
        int len=S.length();
        int[] freq=new int[26];
        for (int i = 0; i < len; i++) {
            freq[S.charAt(i)-'a']++;
        }
        long[] fact=new long[len];
        fact[0]=1;
        fact[1]=1;
        for (int i = 2; i <len ; i++) {
            fact[i]=fact[i-1]*i;
        }
        long res=1;
        for (int i = 0; i < len; i++) {
            int count=0;
            for (int j = i; j < S.charAt(i)-'a'; j++) {
                count+=freq[j];
            }
            freq[S.charAt(i)-'a']--;
            res+=count*(fact[len-i-1])%mod;

        }
        return (int) res;
    }


    public static void main(String[] args) {
        System.out.println(rank("vsrtkjpre"));
    }
}
