package revision.string;

public class PalindromicSubstrings {
    public int CountPS(String S, int N)
    {
        boolean[][] dp=new boolean[N][N];
        int count=0;
        for (int i = 0; i < N; i++) {
            dp[i][i]=true;
        }
        for (int i = 0; i < N-1; i++) {
            if(S.charAt(i)==S.charAt(i+1)){
                dp[i][i+1]=true;
                count++;
            }
        }
        for (int i = 2; i < N; i++) {
            for (int j = i,k=0; j < N; j++,k++) {
                if(S.charAt(k)==S.charAt(j) && dp[k+1][j-1]){
                    dp[k][j]=true;
                    count++;
                }

            }
        }
        return count;
    }
}
