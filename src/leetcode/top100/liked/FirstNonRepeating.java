package leetcode.top100.liked;

public class FirstNonRepeating {
    public static int firstUniqChar(String s) {
        int alphabets[]=new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(alphabets[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
    public int firstUniqCharBest(String s) {
        int res = s.length();
        for(char ch = 'a'; ch <='z';ch++){
            int id = s.indexOf(ch);
            if(id!=-1 && id==s.lastIndexOf(ch)){
                if(id==0){
                    return 0;
                }
                res=Math.min(res,id);
            }
        }
        return res==s.length()?-1:res;
    }

    public int firstUniqCharBest2(String s) {
        int alphabets[]=new int[26];
        for (int i = 0; i < s.length(); i++) {
            int indexInArr = s.charAt(i) - 'a';
            if(alphabets[indexInArr] ==0) {
                if (s.lastIndexOf(s.charAt(i)) == i) {
                    return i;
                } else {
                    alphabets[indexInArr]++;
                }
            }
        }
        return -1;

    }


    public static void main(String[] args) {

    }
}
