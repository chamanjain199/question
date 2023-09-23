package geeksForGeeks.bitmanipulation;

import java.util.*;

public class SufficientTeam {

    List<Integer> ans = new ArrayList<>();
    int checkMask = 0;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> skipMap = new HashMap<>(req_skills.length);
        for (int i = 0; i < req_skills.length; i++) {
            skipMap.put(req_skills[i], i);
        }
        checkMask = (1 << (req_skills.length)) - 1;
        int[] peopleSet = new int[people.size()];
        for (List<String> tpeople :
                people) {
            Optional<List<String>> ansss = people.stream().filter(x -> !x.equals(tpeople) && new HashSet<>(x).containsAll(tpeople)).findFirst();
            if (ansss.isPresent()) {
                tpeople.clear();
            }
        }


        for (int i = 0; i < people.size(); i++) {
            List<String> skills = people.get(i);
            for (int j = 0; j < skills.size(); j++) {
                peopleSet[i] = peopleSet[i] | 1 << skipMap.get(skills.get(j));
            }

        }
        sufficientTeam(peopleSet.length - 1, peopleSet, 0, new ArrayList<>());

        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    public  void sufficientTeam(int n, int[] peoples, int peopleMask, List<Integer> list) {
        if (peopleMask == checkMask || n==-1) {
            if (peopleMask == checkMask) {
                if (ans.isEmpty()) {
                    ans.addAll(list);
                } else if (list.size() < ans.size())
                    ans = new ArrayList<>(list);
            }
            return;
        }

        sufficientTeam(n - 1, peoples, peopleMask, list);
        if (peoples[n] != 0) {
            list.add(n);
            sufficientTeam(n - 1, peoples, peopleMask | peoples[n], list);
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("java");
        List<String> l2 = new ArrayList<>();
        l2.add("nodejs");
        List<String> l3 = new ArrayList<>();
        l3.add("nodejs");
        l3.add("reactjs");

        input.add(l1);
        input.add(l2);
        input.add(l3);
        SufficientTeam obj=new SufficientTeam();
        System.out.println(Arrays.toString(obj.smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"},input)));
    }
}
