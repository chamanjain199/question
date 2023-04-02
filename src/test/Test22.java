package test;

public class Test22 {
    public static void main(String[] args) {
        int input = 7;
        int submask = input;
        while (submask > 0) {
            System.out.println(submask+" "+Integer.toBinaryString(submask));
            submask = input & (submask - 1);
        }


    }
}
