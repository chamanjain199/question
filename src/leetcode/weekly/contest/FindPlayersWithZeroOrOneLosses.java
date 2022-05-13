package leetcode.weekly.contest;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> winners = new HashMap<>(matches.length);
        HashMap<Integer, Integer> oneLossers = new HashMap<>(matches.length);


        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < 1; j++) {
                winners.put(matches[i][0], 1);
                oneLossers.merge(matches[i][1], 1, Integer::sum);
            }
        }
        winners.keySet().removeAll(oneLossers.keySet());
        result.add(winners.keySet().stream().sorted().toList());
        result.add(oneLossers.entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).sorted().toList());
        return result;


    }

    public static List<List<Integer>> findWinners1(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        TreeSet<Integer> winners=new TreeSet<>();
        HashMap<Integer, Integer> oneLossers = new HashMap<>(matches.length);

        for (int i = 0; i < matches.length; i++) {
            winners.add(matches[i][0]);
            oneLossers.merge(matches[i][1], 1, Integer::sum);
        }
        winners.removeAll(oneLossers.keySet());
        result.add(winners.stream().toList());
        result.add(oneLossers.entrySet().stream().filter(x -> x.getValue() == 1).map(Map.Entry::getKey).sorted().toList());
        return result;


    }
    public List<List<Integer>> findNodes(int[][] edges) {
        Set<Integer> all = new HashSet<>(edges.length);
        Map<Integer, Integer> parentCount = new HashMap<>(edges.length);

        for (int [] edge : edges){
            all.add(edge[0]);
            all.add(edge[1]);
            parentCount.put(edge[1], parentCount.getOrDefault(edge[1], 0) + 1);
        }

        List<Integer> zero = new ArrayList<>(edges.length);
        List<Integer> one = new ArrayList<>(edges.length);

        int parents;

        for (int node : all){
            parents = parentCount.getOrDefault(node, 0);

            if (parents == 0)
                zero.add(node);
            else if (parents == 1)
                one.add(node);
        }

        Collections.sort(zero);
        Collections.sort(one);

        return Arrays.asList(zero, one);
    }
    public static List<List<Integer>> findWinners2(int[][] matches){
        Map<Integer, Integer> losses = new TreeMap<>();
        for(int[] m : matches){
            losses.put(m[0], losses.getOrDefault(m[0], 0));
            losses.put(m[1], losses.getOrDefault(m[1], 0) + 1);
        }
        List<List<Integer>> r = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for(Integer player : losses.keySet())
            if(losses.get(player) <= 1)
                r.get(losses.get(player)).add(player);
        return r;
    }

    public static void main(String[] args) {
           findWinners2(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}});
//        findWinners(new int[][]{{1, 2}, {2, 1}});


    }
}
