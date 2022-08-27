package geeksForGeeks.bitmanipulation;

import java.util.*;

public class SufficientTeam {

    static List<Integer> ans = new ArrayList<>();
    static int checkMask = 0;

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
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

    public static void sufficientTeam(int n, int[] peoples, int peopleMask, List<Integer> list) {
        if (peopleMask == checkMask || n == -1) {
            if (ans.isEmpty()) {
                ans.addAll(list);
            } else if (list.size() < ans.size())
                ans = new ArrayList<>(list);
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


        System.out.println(Arrays.toString(smallestSufficientTeam(new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"},
                List.of(List.of("algorithms", "math", "java"), List.of("algorithms", "math", "reactjs"),
                        List.of("java", "csharp", "aws"), List.of("reactjs", "csharp"), List.of("csharp", "math"),
                        List.of("aws", "java")))));
    }
}
