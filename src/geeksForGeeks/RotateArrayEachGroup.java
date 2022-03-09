package geeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class RotateArrayEachGroup {

    static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {

        ArrayList<Integer> newArr=new ArrayList<>(arr.size());
         k=k>n?n:k;
         int gap=k;
         int initial=-1;
        for(int i=k-1;i>initial;i--){
            newArr.add(arr.get(i));
            if(i==initial+1 && k<n){
                initial=k-1;
                k=k+gap;
                k=k>n?n:k;
                i=k;
            }
        }
        arr.clear();;
        arr.addAll(newArr);
    }
    static void reverseInGroups( int arr[], int n, int k) {

        k=k>n?n:k;
        int gap=k;
        int initial=-1;
        for(int i=k-1,j=initial;i>initial;i--){
            arr[i--]=arr[++j];
            if(i==initial+1 && k<n){
                initial=k-1;
                k=k+gap;
                k=k>n?n:k;
                i=k;
            }
        }

  System.out.println(Arrays.toString(arr));


    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
//        33 13
       String input= "36 93 64 48 96 55 70 0 82 30 16 22 38 53 19 50 91 43 70 88 10 57 14 94 13 36 59 32 54 58 18 82 67";
       input="35 56 48 21 87";
        list= Arrays.stream(input.split(" ")).map(x->Integer.valueOf(x)).collect(Collectors.toCollection(ArrayList::new));
       // reverseInGroups(list,5,77);

//        5 77
//        35 56 48 21 87
        System.out.println(list);

        int arr[]=new int[]{35, 56 ,48, 21 ,87};
        reverseInGroups(arr,5,77);

    }
}
