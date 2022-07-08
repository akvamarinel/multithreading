package org.masha;

public class MyQueue implements QueueInterface<Integer>{
    private final int capacity;
    private final int size;

    public MyQueue(final int capacity, final int size){
        this.capacity = capacity;
        this.size = size;
    }

    @Override
    public void push(Integer value) {

    }

    @Override
    public Integer pop() {
        return null;
    }

    @Override
    public Integer get() {
        return null;
    }

}
