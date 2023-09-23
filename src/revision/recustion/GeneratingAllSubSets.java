package revision.recustion;

import java.util.ArrayList;
import java.util.List;

public class GeneratingAllSubSets {

    List<String> ans;

    public List<String> AllPossibleStrings(String s) {
        ans = new ArrayList<>();
        allPossibleStringsHelpr(s, 0, s.length(), "");
        ans.sort(null);
        return ans;
    }

    public void allPossibleStringsHelpr(String s, int index, int len, String temp) {
        if (index == len) {
            if (!temp.isEmpty())
                ans.add(temp);
            return;
        }
        allPossibleStringsHelpr(s, index + 1, len, temp + s.charAt(index));
        allPossibleStringsHelpr(s, index + 1, len, temp);
    }

    public static void main(String[] args) {
        GeneratingAllSubSets obj = new GeneratingAllSubSets();
        System.out.println(obj.AllPossibleStrings("ABC"));
    }
}
