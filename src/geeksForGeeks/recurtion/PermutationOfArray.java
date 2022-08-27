package geeksForGeeks.recurtion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfArray {
    public List<String> find_permutation(String S) {
        List<String> ansList = new ArrayList<>();
        char[] chars =S.toCharArray();
        Arrays.sort(chars);
        permutation_with_swap(chars, 0, ansList, S.length());
       // List<String> ansList1 = new ArrayList<>();
        //permutation_with_rec(S, new StringBuilder(), 0, ansList1, S.length(), new boolean[S.length()]);
        //ansList1.sort(null);

        return ansList;
    }

    public void permutation_with_rec(String S, StringBuilder sb, int index, List<String> result, int size, boolean[] flag) {
        if (index == size) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < size; i++) {
            if (!flag[i]) {
                flag[i] = true;
                sb.append(S.charAt(i));
                permutation_with_rec(S, sb, index + 1, result, size, flag);
                sb.deleteCharAt(sb.length() - 1);
                flag[i] = false;
            }
        }
    }

    public void permutation_with_swap(char arr[], int index, List<String> result, int size) {
        if (index == size) {
            result.add(new String(arr));
            return;
        }
        for (int i = index; i < size; i++) {
            if(i>index && arr[i]==arr[i-1]) continue; //for unique
            swap(arr, index, i);
            permutation_with_swap(arr, index+ 1, result, size);
            swap(arr, i, index);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char charAtI = arr[i];
        char charAtJ = arr[j];
        arr[i] = charAtJ;
        arr[j] = charAtI;
    }
    Integer sum=0;
    public int[] permutaion(int N)
    {
        List<String> ansList = new ArrayList<>();
        String str=String.valueOf(N);
        char chars[]=str.toCharArray();
        Arrays.sort(chars);

        int count=permutation_with_swap(chars, 0, str.length());
        return new int[]{count,sum};
    }
    public int permutation_with_swap(char arr[], int index, int size) {
        if (index == size) {
            sum+= Integer.parseInt(new String(arr));
            return 1;
        }
        int count=0;
        for (int i = index; i < size; i++) {
            if(i>index && arr[i]==arr[i-1]) continue; //for unique
            swap(arr, index, i);
            count+=permutation_with_swap(arr, index+ 1, size);
            swap(arr, i, index);
        }
        return count;
    }



    public static void main(String[] args) {
        PermutationOfArray permutationOfArray = new PermutationOfArray();
        System.out.println(permutationOfArray.find_permutation("BAAC"));
        System.out.println(Arrays.toString(permutationOfArray.permutaion(1002)));
    }
}
