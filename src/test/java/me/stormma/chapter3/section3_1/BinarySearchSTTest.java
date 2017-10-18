package me.stormma.chapter3.section3_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class BinarySearchSTTest {

    private static final Logger logger = LoggerFactory.getLogger(BinarySearchSTTest.class);

    private static BinarySearchST<String, Integer> st;

    @Before
    public void testPut() {
        st = new BinarySearchST<String, Integer>(10);
        st.put("stormma", 20);
        st.put("jack", 21);
        st.put("mary", 19);
        st.put("jerry", 22);
        st.put("stormma", 23);
        st.put("alo", 29);
        st.put("brant", 30);
        st.put("cool", 31);
    }

    @Test
    public void testDelete() {
        logger.info("delete min value: {}", st.deleteMin());
        logger.info("delete max value: {}", st.deleteMax());
        Random random = new Random();
        logger.info("Random delete: {}", st.delete(st.select(random.nextInt(st.size() - 1))));
    }

    @Test
    public void testSelect() {
        logger.info("{}", st.select(0));
    }

    @Test
    public void testMinAndMax() {
        logger.info("{}", st.min());
        logger.info("{}", st.max());
    }

    @Test
    public void testGet() {
        logger.info("{}", st.get("stormma"));
    }

    @Test
    public void testKeysRange() {
        // answer: [alo, brant, cool]
        logger.info("between alo ~ jack: {}", st.keys("alo", "jack"));
    }

    @After
    public void testKeys() {
        for (String key : st.keys()) {
            logger.info("{}==>{}", key, st.get(key));
        }
    }
}
