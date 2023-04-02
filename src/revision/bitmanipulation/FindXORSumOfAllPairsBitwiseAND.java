package revision.bitmanipulation;

public class FindXORSumOfAllPairsBitwiseAND {
    public int getXORSum(int[] arr1, int[] arr2) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            num1 ^= arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            num2 ^= arr2[i];
        }
        return num1 & num2;

    }
}
