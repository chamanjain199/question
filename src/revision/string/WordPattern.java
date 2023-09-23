package revision.string;

import java.util.HashMap;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] stringArr = s.split(" ");
        int len = pattern.length();
        if (stringArr.length != len) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            Character c=pattern.charAt(i);
            String val=map.get(c);
            if(val==null){
                if(map.containsValue(stringArr[i])){
                    return false;
                }
                map.put(c,stringArr[i]);
            }else{
                if(!val.equals(stringArr[i])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
