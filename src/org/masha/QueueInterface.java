package org.masha;

public interface QueueInterface <T> {
    void push(T value);
    T pop();
    T get();
}


