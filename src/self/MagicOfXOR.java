package self;

public class MagicOfXOR {

    public void swapTwoNumbers(){
        int i=9;
        int j=10;
        i=i^j;
        j=i^j;
        i=i^j;
        System.out.println(i+" "+j);
    }
    public static void findMissionNumber(){
         int ars[]=new int[]{1,4,3,5,7,9,8,6};
         int xorOf1to9=0;
        int xorOfAllArrayElement=0;
        for (int i = 0; i <= 9; i++) {
            xorOf1to9= xorOf1to9^i;
        }
        for (int i = 0; i < ars.length; i++) {
            xorOfAllArrayElement= xorOfAllArrayElement^ars[i];
        }

        System.out.println(xorOf1to9^xorOfAllArrayElement);
    }

    public static void main(String[] args) {
        System.out.println(5^9);
        findMissionNumber();


    }
}
