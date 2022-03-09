package leetcode.top100.liked;

import java.util.Arrays;

public class RotateArray {
    public static void rotateNotWorking(int[] nums, int k) {
        if(k==0){
            return;
        }
        int n = nums.length;
        int[] numsTemp = new int[n];

        numsTemp[0] = nums[0];
        int tempv = nums[0];

        if (n % 2 == 0  && k!=1 &&  (k%2==0 || n%k==0) ) {
             System.out.println("k "+(k));

            rotate(nums, 1);
            rotate(nums, k-1);

            return;
        } else {
            for (int i = 0; i < n; i++) {
                int tempVV = tempv;
                tempv = nums[(i * k + (k)) % n];
                nums[(i * k + (k)) % n] = tempVV;
            }
            return;
        }

    }
    public static void rotate(int[] nums, int k) {
        if(k==0 || nums.length<2){
            return;
        }

       int n=nums.length;
        if(k>n){
            k=k%n;
        }
        rorateByN(nums,0,n);
        rorateByN(nums,0,k);
        rorateByN(nums,k,n);



    }
    public void rotate1(int[] nums, int k) {
        int N = nums.length;
        int[] tempArray = new int[N];

        for(int I = 0 ; I < N ; I++) {
            tempArray[(I + k) % N] = nums[I];
        }

        for(int I = 0 ; I < N ; I++) {
            nums[I] = tempArray[I];
        }

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
        int arr[] = new int[]{1,2};


        rotate(arr,3);
        System.out.println(Arrays.toString(arr));


    }
}
