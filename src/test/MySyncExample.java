package test;

class Display {

    

    public synchronized void wish() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.print("Good morning :");
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public void wish2() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.print("Good evening : ");
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
        }
    }

}

public class MySyncExample extends Thread {
    Display display;
    String name;

    MySyncExample(Display display, String name) {
        super(name);
        this.name = name;
        this.display = display;
    }

    public void run() {
        try {
            if (name.equals("T1")) {
                display.wish();
                display.wish2();
            } else {
                display.wish2();
                display.wish();

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Display d = new Display();
        MySyncExample t1 = new MySyncExample(d, "T1");
        t1.start();
        MySyncExample t2 = new MySyncExample(d, "T2");
        t2.start();
    }
}
