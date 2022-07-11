package org.masha;

import org.masha.queue.QueueInterface;

public class Producer implements Runnable{
    private int[] values;
    private QueueInterface<Integer> myQueue;

    public Producer(final int[] values, QueueInterface<Integer> myQueue){
        this.values = values;
        this.myQueue = myQueue;
    }
    @Override
    public void run(){
        for (int i = 0; i < values.length; i++){
            try {
                myQueue.push(values[i]);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
