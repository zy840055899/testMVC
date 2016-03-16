package thread;

/**
 * Created by zhengying on 16/3/8.
 */
public class TestRunnanle implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": runnable thread running");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new TestRunnanle(), "mythread");
        thread.start();

//        Runnable runnable = new Runnable() {
//            public void run() {
//                System.out.println("nimin runnable run");
//            }
//        };
//
//        Thread thread1 = new Thread(runnable);
//        thread1.start();

        System.out.println("--------------------------");

        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                @Override
                public void run() {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread:" + getName() + " running");
                }
            }.start();
        }
    }
}
