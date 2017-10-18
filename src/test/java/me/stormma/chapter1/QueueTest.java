package me.stormma.chapter1;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This {@code QueueTest} class in order to test {@Queue} class.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class QueueTest {

    private static final Logger logger = LoggerFactory.getLogger(QueueTest.class);

    private static Queue<Integer> queue;

    @Before
    public void testEnqueue() {
        queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
    }

    @Test
    public void testDequeue() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            logger.info("dequeue: {}", queue.dequeue());
        }
    }
}
