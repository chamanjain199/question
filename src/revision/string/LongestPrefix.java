package revision.string;

public class LongestPrefix {
    String longestPrefix(String s) {
        int len=s.length();
        int[] dp=new int[len];
        int prefixLen=0;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i)==s.charAt(prefixLen)){
                dp[i]=++prefixLen;
            }else if(prefixLen>0){
                prefixLen=dp[prefixLen-1];
                i--;
            }
        }
        return s.substring(0,prefixLen);
    }
}
