package test;

public class RightShift {
    public static void main(String[] args) {
        int ten = -10;
        System.out.println(Integer.toBinaryString(ten));
        int rften = ten >> 2;
        System.out.println(Integer.toBinaryString(rften)+" "+rften);
        int trften = ten >>> 2;
        System.out.println(Integer.toBinaryString(trften)+" "+trften);
    }
}
