package leetcode.top100.liked;

public class ReverseString {
    public void reverseString(char[] s) {

        int len= s.length;
        for (int i = 0,j=len-1; i <len/2 ; i++,j--) {
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
        }

    }
    public static void main(String[] args) {

    }
}
