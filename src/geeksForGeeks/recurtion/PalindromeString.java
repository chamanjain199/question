package geeksForGeeks.recurtion;

public class PalindromeString {
    boolean isPalindromeString(String s,int i){
        if(i>=s.length()/2){
            return true;
        }

        return s.charAt(i)==s.charAt(s.length()-i-1) && isPalindromeString(s,i+1);
    }
    public static void main(String[] args) {

        System.out.println(new PalindromeString().isPalindromeString("ABBA",0));
    }
}
