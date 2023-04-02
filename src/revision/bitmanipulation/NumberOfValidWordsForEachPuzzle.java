package revision.bitmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfValidWordsForEachPuzzle {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordMaskCount = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (String word : words) {
            int mask = getStringToBitmask(word);
            wordMaskCount.put(mask, wordMaskCount.getOrDefault(mask, 0) + 1);
        }
        for (String puzzle : puzzles) {
            int firstBitMask = (1 << puzzle.charAt(0) - 'a');
            int bitmask = getStringToBitmask(puzzle.substring(1));
            int count = wordMaskCount.getOrDefault(firstBitMask, 0);
            int subMask=bitmask;
            while (subMask > 0) {
                count += wordMaskCount.getOrDefault((subMask | firstBitMask), 0);
                subMask = bitmask & (subMask - 1);
            }
            ans.add(count);
        }
        return ans;
    }

    private static Integer getStringToBitmask(String word) {
        int mask = 0;
        for (char ch : word.toCharArray()) {
            mask |= 1 << (ch - 'a');
        }
        return mask;
    }

    public static void main(String[] args) {

    }
}
