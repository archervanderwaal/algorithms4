package me.stormma.chapter3.section3_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author stormma
 * @date 2017/10/17
 */
public class BSTTest {

    private static final Logger logger = LoggerFactory.getLogger(BSTTest.class);

    private static BST<String, Integer> bst;

    @Before
    public void testPut() {
        bst = new BST<>();
        bst.put("S", 0);
        bst.put("E", 0);
        bst.put("X", 0);
        bst.put("R", 0);
        bst.put("M", 0);
        bst.put("H", 0);
        bst.put("C", 0);
        bst.put("A", 0);
        logger.info("init bst data: {}", bst.keys());
    }

    @Test
    public void testFloor() {
        logger.info("'G' floor key: {}", bst.floor("G"));
        logger.info("'L' ceil key: {}", bst.ceil("L") );
    }

    @Test
    public void testRank() {
        logger.info("{}", bst.rank("S"));
    }

    @Test
    public void testSelect() {
        logger.info("{}", bst.select(-1));
    }

    @Test
    public void testDeleteMin() {
        bst.deleteMin();
    }

    @Test
    public void testDelete() {
        bst.delete("S");
    }

    @Test
    public void testKeys() {
        logger.info("{}", bst.keys());
    }

    @Test
    public void testHeight() {
        logger.info("height: {}", bst.height());
    }

    @After
    public void testOrder() {
        bst.inOrder();
    }
}
