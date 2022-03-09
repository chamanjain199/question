package geeksForGeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequenciesOfLimitedRanfeArray {
    public static void frequencyCount(int arr[], int N, int P) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], (map.getOrDefault(arr[i], 0)) + 1);
        }

        if(P>arr.length){
            P=arr.length;

        }
        for (int i = 1,j=0; i <= P; i++,j++) {
            Integer val = map.get(i);
            if (val != null) {
                arr[j] = val;
            } else {
                arr[j] = 0;
            }
        }
        if (P < arr.length)
            for (int i = P; i < arr.length; i++) {
                arr[i] = 0;
            }


    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};

        frequencyCount(arr, 5, 1);
        System.out.println(Arrays.toString(arr));


    }

}
