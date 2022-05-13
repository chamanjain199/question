package leetcode.biweekly.contest;

public class MinimumBitFlipsToConvertNumber {
    public static int minBitFlips(int start, int goal) {

        String startBinary = Integer.toBinaryString(start);
        String goalBinary = Integer.toBinaryString(goal);
        char[] c1 = startBinary.toCharArray();
        char[] c2 = goalBinary.toCharArray();

        int j=c1.length-1;
        int flipCount=0;
        int i = c2.length-1;
        for (; j>=0 && i>=0; i--,j--) {

            if(c1[j]!=c2[i]){
                flipCount++;
            }
        }
        for ( ;i>=0 ; i--) {
           if(c2[i]=='1'){
               flipCount++;
           }
        }
        for ( ;j>=0 ; j--) {
            if(c1[j]=='1'){
                flipCount++;
            }
        }
          return flipCount;



    }

    public static void main(String[] args) {
        minBitFlips(10,7);
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(7));

    }
}
