package me.stormma.chapter3.section3_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequentialSearchSTTest {

    private static final Logger logger = LoggerFactory.getLogger(SequentialSearchSTTest.class);

    private static SequentialSearchST<String, Integer> st;

    @Before
    public void testPut() {
        st = new SequentialSearchST<String, Integer>();
        st.put("stormma", 11);
        st.put("stormma", 12);
        st.put("jack", 11);
        st.put("mary", 11);
        st.put("hhhh", 11);
    }

    @Test
    public void testGet() {
        logger.info("{}", st.get("stormma"));
    }

    @Test
    public void testDelete() {
        logger.info("{}", st.delete("stormma"));
    }

    @After
    public void testKeys() {
        for (String key: st.keys()) {
            logger.info("{}==>{}", key, st.get(key));
        }
    }
}
