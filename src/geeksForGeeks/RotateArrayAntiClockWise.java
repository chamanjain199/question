package geeksForGeeks;

import java.util.Arrays;

public class RotateArrayAntiClockWise {

    public static void rotate(int[] nums, int k) {
        if(k==0 || nums.length<2){
            return;
        }
        int n=nums.length;
        if(k>n){
            k=k%n;
        }
        rorateByN(nums,0,n);
        rorateByN(nums,0,n-k);
        rorateByN(nums,n-k,n);
    }
    private static void rorateByN(int arr[],int start,int end){

        for (int i=start,j=end-1;i<end;i++,j--){
            if(i>j){
                break;
            }
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }

    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};


        rotate(arr,2);
        System.out.println(Arrays.toString(arr));
    }
}
