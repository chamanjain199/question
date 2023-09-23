package revision.recustion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
    Map<String, Boolean> booleanMap;
    List<List<String>> ans;

    public List<List<String>> partition(String s) {
        booleanMap = new HashMap<>();
        ans = new ArrayList<>();
        palindromeHelper(s, 0, s.length(), new ArrayList<>());
        return ans;
    }

    private void palindromeHelper(String s, int index, int len, List<String> subList) {
        if (index == len) {
            ans.add(new ArrayList<>(subList));
            return;
        }
        for (int i = index; i < len; i++) {
            String sub = s.substring(index, i+1);

            if (booleanMap.get(sub)==Boolean.TRUE || isPalindrome(sub)) {
                booleanMap.put(sub, true);
                subList.add(sub);
                palindromeHelper(s, i + 1, len, subList);
                subList.remove(subList.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning obj=new PalindromePartitioning();
        System.out.println(obj.partition("aab"));
    }
}
