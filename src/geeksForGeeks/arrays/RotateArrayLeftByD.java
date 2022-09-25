package geeksForGeeks.arrays;

import java.util.Arrays;

public class RotateArrayLeftByD {
    static void rotateArrUsingExtraSpace(int arr[], int d, int n) {

    }
    static void rotateArr(int arr[], int d, int n) {
        d=d%n;
        swapArray(arr,0,n);
        swapArray(arr,0,n-d);
        swapArray(arr,n-d+1,n);
    }
    private static void swapArray(int[] arr,int start, int end){
        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr=new int[] {2,4,6,8,10,12,14,16,18,20};
        rotateArr(arr,3,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
