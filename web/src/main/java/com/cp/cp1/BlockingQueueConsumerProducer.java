package com.cp.cp1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueConsumerProducer {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(10);

        ConsumerThread3 c1 =  new ConsumerThread3(queue);

        ConsumerThread3 c2 = new ConsumerThread3(queue);

        ProducerThread3 p1 = new ProducerThread3(queue);

        ProducerThread3 p2 = new ProducerThread3(queue);

        p1.start();

        c1.start();

        c2.start();

        p2.start();

    }

}


