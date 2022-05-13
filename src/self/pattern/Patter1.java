package self.pattern;

public class Patter1 {

    public static void patter0() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void patter1() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void patter2() {
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void patter3() {
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 5; j++) {
                if (j >= i)
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }

    public static void patter4() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j >= i)
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }
    public static void patter5() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j >= i)
                    System.out.print(" * ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        patter0();
        System.out.println();
        patter1();
        System.out.println();
        patter2();
        patter3();
        System.out.println();
        patter4();
        System.out.println();
        patter5();
    }
}
