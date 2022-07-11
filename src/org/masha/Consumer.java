package org.masha;

import org.masha.queue.QueueInterface;

public class Consumer implements Runnable{
    private QueueInterface<Integer> myQueue;

    public Consumer(QueueInterface<Integer> myQueue){
        this.myQueue = myQueue;
    }

    public Integer pop() throws InterruptedException {
        return myQueue.pop();
    }

    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(pop() + " " + Thread.currentThread().getId());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
