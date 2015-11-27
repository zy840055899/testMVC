package com.test.test.spider;

import java.util.LinkedList;

public class Queue {

    private LinkedList queue = new LinkedList();

    public void enQueue(Object t) {
        queue.add(t);
    }

    public Object deQueue() {
        return queue.removeFirst();
    }

    public boolean contains(Object t) {
        return queue.contains(t);
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
