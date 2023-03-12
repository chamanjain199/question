package test;

interface A {
    public default void m1() {
        System.out.println("ddd");
    }

    public void m2();
}

interface B {
    public default void m1() {
        System.out.println("ddd");
    }
    public void m2();

}

