package be.jochenhansoul.sleep;

public class PrintAppLambda {
    public static void main(String[] args)
        throws InterruptedException {
        Thread thread1 = new Thread(() -> print('#', 50));
        Thread thread2 = new Thread(() -> print('*', 50));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("End");
    }

    public static void print(char c, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
            //System.out.println(Thread.interrupted());
            //Thread.yield();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
