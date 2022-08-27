package leetcode.daily.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GraphNode implements Comparable<GraphNode> {
    public String name;
    public int distance=Integer.MAX_VALUE/10;
    public int index;
    public boolean visited=false;
    List<GraphNode> neighbours=new ArrayList<>();
    Map<GraphNode, Integer> neighboursMap;

    public GraphNode(int index) {

        this.index = index;
    }

    @Override
    public int compareTo(GraphNode o) {
        return this.distance - o.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return index == graphNode.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

}
