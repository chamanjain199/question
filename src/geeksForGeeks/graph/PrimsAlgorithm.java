package geeksForGeeks.graph;

import java.util.*;



public class PrimsAlgorithm {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int sum = 0;
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        boolean[] visited = new boolean[V];
        priorityQueue.add(new Pair(0, 0, -1));
        while (!priorityQueue.isEmpty()) {
            Pair cur = priorityQueue.poll();
            sum = sum + cur.weight;
            visited[cur.node] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(cur.node);
            for (ArrayList<Integer> neighbour : neighbours) {
                if (!visited[neighbour.get(0)]) {
                    Pair pair = get(priorityQueue, neighbour.get(0));
                    if (pair != null) {
                        if (pair.weight > neighbour.get(1)) {
                            pair.weight = neighbour.get(1);
                            priorityQueue.remove(pair);
                            priorityQueue.add(pair);
                        }
                    } else {
                        priorityQueue.add(new Pair(neighbour.get(0), neighbour.get(1), cur.node));
                    }
                }
            }
        }
        return sum;
    }

    static int spanningTree2(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int sum = 0;
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        boolean[] visited = new boolean[V];
        priorityQueue.add(new Pair(0, 0, -1));
        while (!priorityQueue.isEmpty()) {
            Pair cur = priorityQueue.poll();
            if (!visited[cur.node]) {
                sum = sum + cur.weight;
                visited[cur.node] = true;
                ArrayList<ArrayList<Integer>> neighbours = adj.get(cur.node);
                for (ArrayList<Integer> neighbour : neighbours) {
                    if (!visited[neighbour.get(0)]) {
                        priorityQueue.add(new Pair(neighbour.get(0), neighbour.get(1), cur.node));
                    }
                }
            }
        }
        return sum;
    }

    static Pair get(Queue<Pair> priorityQueue, int node) {
        Optional<Pair> found = priorityQueue.stream().filter(x -> x.node == node).findFirst();
        return found.orElse(null);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> input = new ArrayList<>();
        ArrayList<ArrayList<Integer>> input1 = new ArrayList<>();
        ArrayList<Integer> input01 = new ArrayList<>();
        input01.add(1);
        input01.add(5);

        ArrayList<Integer> input02 = new ArrayList<>();
        input02.add(2);
        input02.add(1);

        input1.add(input01);
        input1.add(input02);

        ArrayList<ArrayList<Integer>> input2 = new ArrayList<>();
        ArrayList<Integer> input11 = new ArrayList<>();
        input11.add(0);
        input11.add(5);

        ArrayList<Integer> input12 = new ArrayList<>();
        input12.add(2);
        input12.add(3);

        input2.add(input11);
        input2.add(input12);

        ArrayList<ArrayList<Integer>> input3 = new ArrayList<>();
        ArrayList<Integer> input21 = new ArrayList<>();
        input21.add(0);
        input21.add(1);

        ArrayList<Integer> input22 = new ArrayList<>();
        input22.add(1);
        input22.add(3);

        input3.add(input21);
        input3.add(input22);
        input.add(input1);
        input.add(input2);
        input.add(input3);

        System.out.println(spanningTree(3, input));


    }
}
