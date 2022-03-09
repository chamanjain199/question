package leetcode.top100.liked;

public class Sqrt {

    public static int mySqrt(int x) {
        long count=0;
        if(x==1){
            return 1;
        }
        long num = x / 2;
        long lastNum = num;
        while ((num * num) > x) {
            lastNum = num;
            num = num / 2;
            count++;

        }
        while (num < lastNum) {
            long avg = (num + lastNum) / 2;
            if (avg * avg > x) {
                lastNum = avg;
            } else {
                num = avg;
                num++;
            }
            count++;

        }
        System.out.println("Print count  1 "+count);

        if (num * num > x) {
            return (int) num - 1;
        }
        return (int) num;
    }

    public static int mySqrt1(int x) {
        long num = 1;
        long lastNum = x/2;
        while (num < lastNum) {
            long avg = (num + lastNum) / 2;
            if (avg * avg > x) {
                lastNum = avg-1;
            } else {
                num = avg+1;
            }
        }
        if (num * num > x) {
            return (int) num - 1;
        }
        return (int) num;
    }
    public static int mySqrt2(int x) {

        long ans = 0;
        long start = 1;
        long end = x/2;
        while( start <= end ){
            long mid = (start +  end ) / 2;
            if( mid * mid <= x ){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return (int)ans;
    }
    public static int mySqrt4(int x) {
        long count=0;
        long ans = 1;
        long start = 1;
        long end = x/2;
        while( start < end ){
            long mid = (start +end)/ 2;
            if( mid * mid <= x ){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
            count++;
        }
        System.out.println("Print count  3 "+count);

        return (int)ans;
    }
    public static int mySqrt5(int x)
    {
        int s=1;
        int e=x/2;
        int ans=0;
        while(s<=e){
            int mid=(s+e)/2;
            if(mid==x/mid){
                return mid;
            }else if(mid < x/mid){
                ans=mid;
                s=mid+1;
            }else{
                e=mid-1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {



        System.out.println("Result :: 1 " + mySqrt1(0));
        System.out.println("Result :: 2 " + mySqrt2(0));
//        System.out.println("Result :: 3 " + mySqrt2(8));




    }
}
