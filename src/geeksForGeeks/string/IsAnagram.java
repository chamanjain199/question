package geeksForGeeks.string;

public class IsAnagram {
    public static boolean isAnagram(String a,String b)
    {
        if(a.length()!=b.length()){
            return false;
        }
        int alphabets[]=new int[26];
        for (int i = 0; i < a.length(); i++) {
            alphabets[a.charAt(i)-'a']++;
            alphabets[b.charAt(i)-'a']--;}

        for (int i = 0; i < 26; i++) {
          if(alphabets[i]!=0){
              return false;
          }
        }

        return true;

    }
    public static void main(String[] args) {

    }
}
