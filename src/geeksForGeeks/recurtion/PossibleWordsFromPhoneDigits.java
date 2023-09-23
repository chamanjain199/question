package geeksForGeeks.recurtion;

import java.util.ArrayList;

public class PossibleWordsFromPhoneDigits {
    static char[][] charMapping = new char[][]{
            {},
            {'a','b','c'},{'d','e','f'},
            {'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };

    static ArrayList<String> possibleWords(int a[], int N) {
        ArrayList<String> result = new ArrayList<>();
        generatePossibleWords(result,a,N,new StringBuilder(),0);
        return result;
    }

    static void generatePossibleWords(ArrayList<String> result, int a[], int N, StringBuilder sb, int level) {
        if (level == N) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < charMapping[a[level]-1].length; i++) {
            sb.append(charMapping[a[level]-1][i]);
            generatePossibleWords(result, a, N, sb, level + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
       
    }

    public static void main(String[] args) {
        System.out.println( possibleWords(new int[]{2,3,4},3));
    }
}
