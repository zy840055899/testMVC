package thread;

/**
 * Created by zhengying on 16/3/8.
 */
public class TestThread extends Thread{

    @Override
    public void run() {
        System.out.println("test thread running");
    }

    public static void main(String[] args) {
        TestThread thread = new TestThread();

        thread.start();


        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println("nimin thread");
            }
        };

        thread1.start();

    }

}
