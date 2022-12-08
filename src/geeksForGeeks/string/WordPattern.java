package geeksForGeeks.string;

import java.util.HashMap;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        int len = pattern.length();
        String[] arr = s.split(" ");
        if (arr.length != len) {
            return false;
        }
        char ch;
        for (int i = 0; i < len; i++) {
            ch = pattern.charAt(i);
            String preMap = map.get(ch);
            if (preMap == null) {
                if(map.containsValue(arr[i])){
                    return false;
                }
                map.put(ch, arr[i]);
            } else if (!preMap.equals(arr[i])) {
                return false;
            }


        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
