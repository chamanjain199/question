package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
    static Map<String, Boolean> mapping;
    static List<List<String>> allPartitions;
    int minCut=2000;

    public List<List<String>> partition(String s) {
        mapping = new HashMap<>();
        allPartitions = new ArrayList<>();
        partitionHelper(s, new ArrayList<>(), 0, s.length());
        return allPartitions;
    }

    private void partitionHelper(String S, List<String> singlePartition, int index, int size) {
        if (index == size) {
            if(singlePartition.size()<minCut){
                minCut=singlePartition.size();
            }
            allPartitions.add(new ArrayList<>(singlePartition));
            return;
        }
        for (int i = index; i < size; i++) {

            String subString = S.substring(index, i + 1);
            if (mapping.get(subString) != null) {
                singlePartition.add(subString);
                partitionHelper(S, singlePartition, i + 1, size);
                singlePartition.remove(singlePartition.size() - 1);
            } else if (isPalindrome(subString)) {
                mapping.put(subString, true);
                singlePartition.add(subString);
                partitionHelper(S, singlePartition, i + 1, size);
                singlePartition.remove(singlePartition.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));
        System.out.println(palindromePartitioning.minCut);

    }
}
