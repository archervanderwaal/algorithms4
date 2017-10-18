package me.stormma.chapter1;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This {@code StackTest} class in order to test {@Stack} class.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class StackTest {

    private static final Logger logger = LoggerFactory.getLogger(StackTest.class);

    private static Stack<Integer> stack;

    @Before
    public void testPush() {
        stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
    }

    @Test
    public void testPeek() {
        logger.info("peek: {}", stack.peek());
    }

    @Test
    public void testPop() {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            logger.info("pop: {}", stack.pop());
        }
    }
}
