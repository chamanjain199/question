package leetcode.top100.liked;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {

        int alphabets[]=new int[26];
        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabets[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(alphabets[i]!=0){
                return false;
            }
        }

        return true;


    }
    public boolean isAnagram1(String s, String t) {
        int a[] = new int[256];
        for (char c : s.toCharArray()) a[(int) c]++;
        for (char c : t.toCharArray()) a[(int) c]--;
        for (int i = 0; i < 256; i++) if (a[i] != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));

    }
}
