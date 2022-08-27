package leetcode;

public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        if(t.length()==1){
            return t.charAt(0);
        }
        int first =s.charAt(0);
        int second = t.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            first ^= s.charAt(i);
        }
        for (int i = 1; i < t.length(); i++) {
            second ^= t.charAt(i);
        }

        return (char)(first^second);

    }
//    char c = 0;
//        for(char cs : s.toCharArray()) c ^= cs;
//        for(char ct : t.toCharArray()) c ^= ct;
//        return c;
    public static void main(String[] args) {
        System.out.println(findTheDifference("", "abcde"));
    }
}
