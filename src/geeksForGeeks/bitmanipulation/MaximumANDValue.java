package geeksForGeeks.bitmanipulation;

public class MaximumANDValue {

    public static int maxAND(int arr[], int N) {
        int pattern = 0;
        for (int i = 31; i>=0; i--) {
            int val=pattern | 1<<i;
            int count=0;
            for (int j = 0; j < N; j++) {
                if((arr[j]&val)==val){
                    count++;
                }
            }
            if(count>=2){
                pattern|=val;
            }
        }

        return pattern;

    }

    public static void main(String[] args) {

        System.out.println(maxAND(new int[]{4,8,12,16},4));
    }
}
