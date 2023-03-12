package geeksForGeeks.graph;

import java.util.*;

public class WordLadderII {
    public static ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Set<String> allWords = new HashSet<>(Arrays.asList(wordList));
        allWords.remove(startWord);
        int len = startWord.length();
        Queue<ArrayList<String>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(startWord)));
        int minLenSeq = 0;
        while (!queue.isEmpty()) {
            int qsize = queue.size();
            List<String> toRemove = new ArrayList<>();
            for (int q = 0; q < qsize; q++) {
                ArrayList<String> subList = queue.poll();
                String lastWord = subList.get(subList.size() - 1);
                if (lastWord.equals(targetWord)) {
                    int size = subList.size();
                    if (minLenSeq == 0 || size == minLenSeq) {
                        minLenSeq = size;
                        ans.add(subList);
                    }
                    continue;
                }
                for (int i = 0; i < len; i++) {
                    char[] charOfLastWord = lastWord.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        charOfLastWord[i] = ch;
                        String newWord = new String(charOfLastWord);
                        if (allWords.contains(newWord)) {
                            ArrayList<String> newList = new ArrayList<>(subList);
                            newList.add(newWord);
                            queue.add(newList);
                            toRemove.add(newWord);
                        }
                    }
                }
            }

            toRemove.forEach(allWords::remove);
        }
        return ans;
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        HashSet<String> sets = new HashSet<>(wordList);
        Queue<WordLadderInfo> queue = new LinkedList<>();
        queue.add(new WordLadderInfo(beginWord, 1));
        sets.remove(beginWord);
        HashMap<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            WordLadderInfo changeWord = queue.poll();
            if (changeWord.word.equals(endWord)) {
                map.put(endWord, changeWord.level);
                break;
            }
            for (int i = 0; i < len; i++) {
                char[] changeWordStr = changeWord.word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    changeWordStr[i] = ch;
                    String word = new String(changeWordStr);
                    if (sets.contains(word)) {
                        sets.remove(word);
                        map.put(word, changeWord.level + 1);
                        queue.add(new WordLadderInfo(word, changeWord.level + 1));
                    }
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        if (map.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, path, len, ans, map, beginWord);
        }

        return ans;
    }

    public static void dfs(String word, List<String> path, int len, List<List<String>> ans, Map<String, Integer> mapp, String endWord) {

        if (word.equals(endWord)) {
            List<String> dup = new ArrayList<>(path);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        int step = mapp.get(word);

        for (int i = 0; i < len; i++) {
            char[] wordToChar = word.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                wordToChar[i] = ch;
                String newModifiedWord = new String(wordToChar);
                Integer newWordStep = mapp.get(newModifiedWord);
                if (newWordStep != null && (newWordStep + 1) == step) {
                    path.add(newModifiedWord);
                    dfs(newModifiedWord, path, len, ans, mapp, endWord);
                    path.remove(path.size() - 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        List<String> input=new ArrayList<>();
        input.add("hot");
        input.add("dot");
        input.add("dog");
        input.add("lot");
        input.add("log");
        input.add("cog");
        System.out.println(findLadders("hit", "cog", input));
    }
}
