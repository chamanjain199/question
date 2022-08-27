package geeksForGeeks.bitmanipulation;

import java.util.*;

public class NumberOfValidWordsForEachPuzzle {
    public static List<Integer> findNumOfValidWordsTimeOut(String[] words, String[] puzzles) {

        HashMap<Character, List<Integer>> maskStartWithChar = new HashMap<>(26);
        char[] wordChar;
        for (String word :
                words) {
            wordChar = word.toCharArray();
            int mask = 0;
            for (char c : wordChar) {
                mask = mask | 1 << (c - 'a');
            }
            HashSet<Character> hashSet = new HashSet<>(wordChar.length);
            for (Character c : wordChar) {
                if (hashSet.add(c))
                    maskStartWithChar.computeIfAbsent(c, key -> new ArrayList<>()).add(mask);
            }
        }
        List<Integer> ans = new ArrayList<>(puzzles.length);
        Map<String, Integer> dp = new HashMap<>(puzzles.length);
        for (String puzzle :
                puzzles) {
            Integer alreadyPresentCount = dp.get(puzzle);
            if (alreadyPresentCount != null) {
                ans.add(alreadyPresentCount);
                continue;
            }
            wordChar = puzzle.toCharArray();
            int mask = 0;
            for (char c : wordChar) {
                mask = mask | 1 << (c - 'a');
            }


            List<Integer> maskStartWithFirstChar = maskStartWithChar.get(puzzle.charAt(0));
            int count = 0;
            if (maskStartWithFirstChar != null)
                for (Integer wordMask :
                        maskStartWithFirstChar) {
                    if ((mask & wordMask) == wordMask) {
                        count++;
                    }

                }
            ans.add(count);
            dp.put(puzzle, count);

        }
        return ans;
    }

    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordsMask = new HashMap<>(words.length);
        for (String word :
                words) {
            int mask =bitmask(word);
            wordsMask.put(mask, wordsMask.getOrDefault(mask, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>(puzzles.length);
        Map<String, Integer> dp = new HashMap<>(puzzles.length);

        for (String puzzle :
                puzzles) {
            Integer alreadyPresentCount = dp.get(puzzle);
            if (alreadyPresentCount != null) {
                ans.add(alreadyPresentCount);
                continue;
            }
            int firstBitMask = (1 << (puzzle.charAt(0) - 'a'));
            int bitmask = bitmask(puzzle.substring(1));
            int count = wordsMask.getOrDefault(firstBitMask,0);
            for (int subMask = bitmask; subMask > 0; subMask = ((subMask - 1) & bitmask)) {
                count += wordsMask.getOrDefault((subMask | firstBitMask), 0);
            }
            ans.add(count);
            dp.put(puzzle, count);
        }
        return ans;
    }

    private static int bitmask(String word) {

        int mask = 0;
        for (char letter : word.toCharArray()) {
            mask |= 1 << (letter - 'a');
        }
        return mask;
    }

    public static void main(String[] args) {


        System.out.println(findNumOfValidWords(new String[]{"aaaa", "asas", "able", "ability", "actt", "actor", "access"}, new String[]{"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"}));
    }
}
