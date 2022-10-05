package geeksForGeeks.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWith0Sum {
    static boolean findsum(int arr[], int n) {
        Map<Integer,Integer> map=new HashMap<>();
        if(arr[0]==0){
            return true;
        }
        map.put(arr[0], 1);
        for (int i = 1; i < n; i++) {


            arr[i] += arr[i - 1];
            if(arr[i]==0){
                return true;
            }
            Integer fre=map.getOrDefault(arr[i],0);
            if(fre!=0){
                return true;
            }
            map.put(arr[i],1);

        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(findsum(new int[]{36, 27, -35, 43, -15, 36, 42 ,-1, -29, 12 ,-23 ,40 ,9 ,13, -24, -10 ,-24, 22, -14, -39, 18, 17, -21 ,32, -20, 12, -27 ,17 ,-15 ,-21 ,-48 ,-28 ,8 ,19},34));
    }
}
