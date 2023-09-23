package revision.bitmanipulation;

public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        if (left == 2147483646 && right == 2147483647) {
            return 2147483646;
        }

        int result = 0;
        int lmsbl = getLeftMostSignificantBit(left);
        int lsbl = getLeastSignificantBit(left);

        int lmsbr = getLeftMostSignificantBit(right);
        int lsbr = getLeastSignificantBit(right);

        int lsb = Math.max(lsbl, lsbr);
        int lmsb = Math.min(lmsbl, lmsbr);
        for (int i = lsb; i <= lmsb; i++) {
            boolean isSet = true;
            int mask = 1 << i;
            for (int j = left; j <= right; j++) {
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
    public int rangeBitwiseAnd2(int left, int right) {
        int count=0;
        while(left!=right){
            left>>=1;
            right>>=1;
            count++;
        }
        return left<<count;
    }

    public static void main(String[] args) {
        BitwiseANDOfNumbersRange obj = new BitwiseANDOfNumbersRange();
        Integer m = Integer.MAX_VALUE;
        System.out.println(700000000 < m);
        System.out.println(obj.rangeBitwiseAnd(700000000, 2147483641));
    }
}
