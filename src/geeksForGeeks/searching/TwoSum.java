package geeksForGeeks.searching;

public class TwoSum {
    public int twoSum(int[] a, int sum) {
        int start = 0;
        int end = a.length - 1;
        int count=0;
        while (start < end) {
            int tsum = a[start] + a[end];
            if (tsum == sum) {
                count++;
            }
            if (tsum > sum) {
                end--;
            } else {
                start++;
            }
        }
        if(count>0){
            return count;
        }
        return -1;

    }

    public static void main(String[] args) {

    }
}
