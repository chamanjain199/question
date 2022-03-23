package test;

public class DivideArrayIntoEqualPairs {

    public static boolean divideArray(int[] nums) {

        int arrs[] = new int[501];

        for (int i = 0; i < nums.length; i++) {
            arrs[nums[i]]++;
        }
        for (int i = 1; i <arrs.length ; i++) {
            if(arrs[i]%2!=0){
                return false;
            }
        }
       return true;

    }

    public static void main(String[] args) {

       System.out.println( divideArray(new int[]{3,2,3,2,2,2}));
    }
}
