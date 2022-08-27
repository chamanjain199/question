package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutationsOfAGivenString {

    BitSet bs = new BitSet();

    public List<String> find_permutation(String S) {
        char[] ch = S.toCharArray();
        Arrays.sort(ch);
        String sortedString = new String(ch);
        List<String> result = new ArrayList<>();
        permute(sortedString, new StringBuilder(), result, 0);
        return result;
    }

    private void permute(String S, StringBuilder sb, List<String> list, int level) {
        if (level == S.length()) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (bs.get(i)) {
                continue;
            }
            bs.set(i);
            sb.append(S.charAt(i));
            permute(S, sb, list, level + 1);
            sb.deleteCharAt(sb.length() - 1);
            bs.set(i, false);
        }
    }

    private static void permuteSwap(String s, int index) {

        if (index == s.length() - 1) {
            System.out.println(s);
            return;
        }
        for (int i = index; i < s.length(); i++) {

            s=swap(s, index, i);
            permuteSwap(s,index+1);
            s=swap(s, i, index);

        }
    }

    static String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        PermutationsOfAGivenString ob = new PermutationsOfAGivenString();
        System.out.println(ob.find_permutation("ABC"));
        permuteSwap("ABC",0);

    }
}
