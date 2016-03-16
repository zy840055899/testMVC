package thread;

/**
 * Created by zhengying on 16/3/9.
 */
public class TestTry {
    public static void main(String[] args) {
        new Thread(new A(), "甲").start();
        new Thread(new A(), "乙").start();
        new Thread(new A(), "丙").start();
    }
}

class A implements Runnable {

    public void run() {
        tiao();
        shi();
        fukuan();
    }

    void tiao() {
        System.out.println(Thread.currentThread().getName() + "挑ing...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void shi() {
        synchronized ("hello") {
            System.out.println(Thread.currentThread().getName() + "试ing...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "试完走人");
        }
    }

    void fukuan() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "付完走人");
    }
}
