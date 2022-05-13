package leetcode.algo.plan.one;

public class IsBadVersion {
    boolean isBadVersion(int n) {
        return n >=1150769282;
    }
    public int firstBadVersionme(int n) {

        if (n == 1) {
            return 1;
        }
        int high = 0;
        while (isBadVersion(n)) {
            high = n;
            n = n / 2;
        }
        while (n < high) {

            int mid=n/2+high/2;
            if (isBadVersion(mid)) {
                high=mid;
            }  else {
                n=mid+1;
            }
        }
        return n;
    }

    public int firstBadVersion(int n) {
        int left=1,right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            if(isBadVersion(mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args) {



        IsBadVersion isBadVersion = new IsBadVersion();
        System.out.println(isBadVersion.firstBadVersion(1420736637));

    }
}
