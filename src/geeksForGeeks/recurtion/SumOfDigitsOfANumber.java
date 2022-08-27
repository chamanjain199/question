package geeksForGeeks.recurtion;

public class SumOfDigitsOfANumber {
    public static int sumOfDigits(int n)
    {
        if(n<10){
            return n;
        }
        return n%10+sumOfDigits(n/10);
    }
    public static int digitalRoot(int n)
    {
        if(n<10){
            return n;
        }
        int num=n%10+digitalRoot(n/10);
        return digitalRoot(num);
    }

    public static void main(String[] args) {
        System.out.println( sumOfDigits(99999)); //45
    }
}
