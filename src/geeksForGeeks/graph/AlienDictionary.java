package geeksForGeeks.graph;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
    public static String findOrder(String[] dict, int N, int K) {
        StringBuilder sb = new StringBuilder();
        List<List<Character>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        int len1 = 0;
        int len2 = 0;

        for (int i = 1; i < N; i++) {
            String firstWord = dict[i - 1];
            len1 = firstWord.length();
            String secondWord = dict[i];
            len2 = secondWord.length();
            int count = 0;
            while (count < len1 && count < len2 && firstWord.charAt(count) == secondWord.charAt(count)) {
                count++;
            }
            if (count < len1 && count < len2) {
                List<Character> subList = adj.get(firstWord.charAt(count) - 'a');
                subList.add(secondWord.charAt(count));
            }
        }
        boolean[] visited = new boolean[K];
        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                dfs((char) (i + 'a'), visited, adj, sb);
            }
        }
        return sb.reverse().toString();
    }

    public static void dfs(char source, boolean[] visited, List<List<Character>> adj, StringBuilder sb) {
        visited[source - 'a'] = true;
        List<Character> children = adj.get(source - 'a');
        for (char child : children) {
            if (!visited[child - 'a']) {
                dfs(child, visited, adj, sb);
            }
        }
        sb.append(source);
    }

    public static void main(String[] args) {
        System.out.println(findOrder(new String[]{"baa", "abcd", "abca", "cab", "cad"}, 5, 4));
    }
}
