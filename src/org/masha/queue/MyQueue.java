package org.masha.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyQueue implements QueueInterface<Integer> {

    private final Queue<Integer> queue;
    private final int capacity;
    private int size;


    public MyQueue(final int capacity) {
        this.queue = new ArrayDeque<>(capacity);
        this.capacity = capacity;
        this.size = 0;
    }

    @Override
    public synchronized void push(Integer value) throws InterruptedException {
        while (size == capacity) {
            wait();
        }
        queue.add(value);
        size++;
        notifyAll();
    }

    @Override
    public synchronized Integer pop() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        Integer tmp = queue.poll();
        size--;
        notifyAll();
        return tmp;
    }
}
