package geeksForGeeks.graph;

import java.util.*;

class WordLadderInfo {
    String word;
    int level;

    public WordLadderInfo(String word, int level) {
        this.word = word;
        this.level = level;
    }
}

public class WordLadderI {
    public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        int len = startWord.length();
        HashSet<String> sets = new HashSet<>(Arrays.asList(wordList));
        Queue<WordLadderInfo> queue = new LinkedList<>();
        queue.add(new WordLadderInfo(startWord, 1));
        sets.remove(startWord);
        while (!queue.isEmpty()) {
            WordLadderInfo changeWord = queue.poll();
            if (changeWord.word.equals(targetWord)) {
                return changeWord.level;
            }
            for (int i = 0; i < len; i++) {
                char[] changeWordStr = changeWord.word.toCharArray();
                for (char ch='a';ch<='z';ch++ ) {
                    changeWordStr[i] = ch;
                    String word = new String(changeWordStr);
                    if (sets.contains(word)) {
                        sets.remove(word);
                        queue.add(new WordLadderInfo(word, changeWord.level + 1));
                    }
                }
            }

        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(wordLadderLength("der", "dfs", new String[]{"des", "der", "dfr", "dgt", "dfs"}));
    }
}
