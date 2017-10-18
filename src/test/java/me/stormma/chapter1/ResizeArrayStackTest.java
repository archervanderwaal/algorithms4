package me.stormma.chapter1;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This {@code ResizeArrayStackTest} class is in order to test {@code ResizeArrayStack} class.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class ResizeArrayStackTest {

    private static final Logger logger = LoggerFactory.getLogger(ResizeArrayStackTest.class);

    private static ResizeArrayStack<Integer> stack;

    @Before
    public void testPush() {
        stack = new ResizeArrayStack<>();
        // default capacity is 10.
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        logger.info("stack's size: {}", stack.size());
    }

    @Test
    public void testPop() {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            logger.info("pop: {}", stack.pop());
        }
    }
}
