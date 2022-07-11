package org.masha.queue;

public interface QueueInterface <T> {
    void push(T value) throws InterruptedException;
    T pop() throws InterruptedException;
}


