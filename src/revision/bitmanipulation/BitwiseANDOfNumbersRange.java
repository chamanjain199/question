package revision.bitmanipulation;

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        int result = 0;
        int lmsb = getLeftMostSignificantBit(left);
        int lsb = getLeastSignificantBit(left);
        for (int i = lsb; i <= lmsb; i++) {
            boolean isSet = true;
            int mask = 1 << i;
            for (long j = left; j <= right; j++) {
                if ((mask & j) == 0) {
                    isSet = false;
                    break;
                }
            }
            if (isSet) {
                result = result | mask;
            }
        }
        return result;
    }

    private int getLeftMostSignificantBit(int number) {
        return (int) (Math.log(number) / Math.log(2));
    }

    private int getLeastSignificantBit(int number) {
        int and = number & (-number);
        double n = (Math.log(and) / Math.log(2));
        return (int) Math.ceil(n);
    }

    public static void main(String[] args) {
        BitwiseANDOfNumbersRange obj = new BitwiseANDOfNumbersRange();
        Integer m=Integer.MAX_VALUE;
        System.out.println(700000000<m);
        System.out.println(obj.rangeBitwiseAnd(700000000, 2147483641));
    }
}
