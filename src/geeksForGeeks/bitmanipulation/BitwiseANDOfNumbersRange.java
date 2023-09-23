package geeksForGeeks.bitmanipulation;

public class BitwiseANDOfNumbersRange {
    public static int rangeBitwiseAnd(int left, int right) {
        if(left==right){
            return left;
        }
        int result=0;
        double pow1 =  (Math.log(left)/Math.log(2));
        int pow11= (int) Math.ceil(pow1);
        if(pow11==31){
            return left;
        }
        int num1= (int) Math.pow(2,pow11);
        int num2= (int) Math.pow(2,pow11+1);
        if(num1>=left && num2<=right){
            return 0;
        }
        int i = 0;

        if(num1>=left && num1<=right){
            i=getFirstSetBit(num1)-1;
        }
        int lmsb=pow11+1;


        for ( ;i <lmsb ; i++) {
            boolean isSet=true;
            for (int j = left; j <=right ; j++) {
                if((j>>i & 1)==0){
                    isSet=false;
                    break;
                }
            }
            if(isSet){
                result|=1<<i;
            }
        }
        return result;
    }

    public static int getFirstSetBit(int n) {
        if (n == 0) {
            return 0;
        }
        int rs = n & (-n);
        int res = (int) (Math.log(rs) / Math.log(2));
        return res + 1;
    }

    public static int rangeBitwiseAndTLE(int left, int right) {
        for (int i = left+1; i <=right ; i++) {
           left&=i;
        }
        return left;
    }
    //https://www.youtube.com/watch?v=-qrpJykY2gE
    public static int rangeBitwiseAndSuperOptimized(int left, int right) {
        int count = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        return left << count;
    }
    public static void main(String[] args) {


        System.out.println(rangeBitwiseAndSuperOptimized(1
                ,2147483647));
    }
}
