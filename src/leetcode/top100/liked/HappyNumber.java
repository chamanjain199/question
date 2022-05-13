package leetcode.top100.liked;

public class HappyNumber {
    public static boolean isHappy(int n) {

        while (n!=1 ){
            int temp=0;
            while (n>0){
                temp+=Math.pow(n%10,2);
                n=n/10;
            }
            if(temp==4){
                return false;
            }
            n=temp;
        }
        return true;

    }
    public static void main(String[] args) {
        System.out.println(isHappy(35));
    }
}
