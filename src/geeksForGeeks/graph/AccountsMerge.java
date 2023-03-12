package geeksForGeeks.graph;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int v = accounts.size();
        Map<String, Integer> idParentMapping = new HashMap<>();
        DisjointSet disjointSet = new DisjointSet(v);
        for (int i = 0; i < v; i++) {
            List<String> allIds = accounts.get(i);
            int cz = allIds.size();
            for (int j = 1; j < cz; j++) {
                Integer parent = idParentMapping.get(allIds.get(j));
                if (parent == null) {
                    idParentMapping.put(allIds.get(j), i);
                } else {
                    disjointSet.unionByRank(parent, i);
                }
            }
        }
        List<String>[] mergeMail = new List[v];
        for (int i = 0; i < v; i++) {
            mergeMail[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> it : idParentMapping.entrySet()) {
            int index = disjointSet.findUParent(it.getValue());
            mergeMail[index].add(it.getKey());
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (mergeMail[i].isEmpty()) continue;
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            Collections.sort(mergeMail[i]);
            temp.addAll(mergeMail[i]);
            ans.add(temp);
        }
        return ans;
    }
}
