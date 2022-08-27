package geeksForGeeks.bitmanipulation;

public class FindXORSumOfAllPairsBitwiseAND {
    public static int getXORSum(int[] arr1, int[] arr2) {
        int arr1ANDOfAllElement = arr1[0];
        int arr2ANDOfAllElement = arr2[0];
        for (int i = 1; i < arr1.length; i++) {
            arr1ANDOfAllElement ^= arr1[i];
        }
        for (int i = 1; i < arr2.length; i++) {
            arr2ANDOfAllElement ^= arr2[i];
        }

        return arr1ANDOfAllElement&arr2ANDOfAllElement;

    }

    public static void main(String[] args) {
        System.out.println(getXORSum(new int[]{1,2,3},new int[]{6,5}));
    }
}
