package self.recursion;

public class Print {

    public static void print1(int num) {
        if (num < 0) {
            return;
        }
        System.out.print(num+" ,");
        print1(num - 1);
    }

    public static void print2(int num) {
        if (num < 0) {
            return;
        }

        print2(num - 1);
        System.out.print(num+" ,");
    }

    public static void main(String[] args) {

        print1(10);
        System.out.println();
        print2(10);
    }
}
