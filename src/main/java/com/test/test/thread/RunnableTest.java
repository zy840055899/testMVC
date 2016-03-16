package com.test.test.thread;

/**
 * Created by zhengying on 16/3/2.
 */
public class RunnableTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(new A());
        t1.start();
        Thread t2 = new Thread(new B());
        t2.start();
    }

}

class A implements Runnable {
    public void run() {
        while (true) {
            System.out.println("AAA");
        }
    }
}

class B implements Runnable {
    public void run() {
        while (true) {
            System.out.println("BBB");
        }
    }
}
