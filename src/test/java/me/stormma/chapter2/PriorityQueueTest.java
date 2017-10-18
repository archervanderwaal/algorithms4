package me.stormma.chapter2;

import org.junit.Test;

public class PriorityQueueTest {

    @Test
    public void testUsePQ() {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(10);
        for(int i = 0; i < 10; i++) {
            maxPQ.insert((int)(Math.random() * 10 + 1));
        }
        while(!maxPQ.isEmpty()) {
            System.out.println(maxPQ.delMax());
        }
    }
}
