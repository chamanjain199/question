package geeksForGeeks.arrays;

public class MaximumOccuredInteger {
    //https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Arrays/problem/maximum-occured-integer4602
    public static int maxOccured(int L[], int R[], int n, int maxx) {
        int arrayWithSum[] = new int[maxx + 2];
        for (int i = 0; i < n; i++) {
            arrayWithSum[L[i]]++;
            arrayWithSum[R[i]+1]--;
        }
        int maxOccuredElement = arrayWithSum[0];
        int res = 0;
        for (int i = 1; i < maxx+2; i++) {
            arrayWithSum[i] += arrayWithSum[i - 1];
            if (arrayWithSum[i] > maxOccuredElement) {
                maxOccuredElement = arrayWithSum[i];
                res = i;
            }
        }
        return res;


    }

    public static void main(String[] args) {
        System.out.println(maxOccured(new int[]{1,4,3,1}, new int[]{15,8,5,4}, 4, 15));
    }
}
