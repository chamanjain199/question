package geeksForGeeks.bitmanipulation;

public class LastSetBit {

      public static int lastSetBit(int n){

         return (int) (Math.log(n)/Math.log(2));

      }

    public static void main(String[] args) {

        System.out.println(lastSetBit(8));
    }
}
