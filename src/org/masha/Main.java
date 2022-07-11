package org.masha;


import org.masha.queue.MyQueue;
import org.masha.queue.QueueInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Main {
   private static int[] values = IntStream.iterate(0, e -> e+1).limit(60).toArray();
   public static void main(String[] args) throws InterruptedException {
      QueueInterface <Integer> myQueue = new MyQueue(6);

      Producer producer = new Producer(values, myQueue);
      Consumer consumer = new Consumer(myQueue);
      Thread threadProd = new Thread(producer);
      List<Thread> threadsConsumers = new ArrayList<>(10);
      for (int i = 0; i < 10; i++){
         threadsConsumers.add(new Thread(consumer));
      }
      threadProd.start();
      threadsConsumers.forEach(Thread::start);
      threadProd.join();
      for (Thread threadsConsumer : threadsConsumers) {
         threadsConsumer.join();
      }
   }
}
