package test;

public class EvenOdd {
    public static void isEvenUsingAND(int number){
        if((number&1)==1){
            System.out.println("Number "+number+" is odd ");
        }else{
            System.out.println("Number "+number+" is even ");
        }
    }

    public static void isEven1(int number){
        if(number%2==0){
            System.out.println("Number "+number+" is even ");
        }else{
            System.out.println("Number "+number+" is odd ");
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i <=100 ; i++) {
            isEvenUsingAND(i);
        }
    }
}
