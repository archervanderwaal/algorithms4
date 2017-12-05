package me.stormma.chapter3.section3_4;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * link {@code SeparateChainingHashSTTest} class
 * @author stormma
 * @date 2017/10/26
 */
public class SeparateChainingHashSTTest {

    private static final Logger logger = LoggerFactory.getLogger(SeparateChainingHashSTTest.class);
    @Test
    public void test() {
        SeparateChainingHashST<String, String> st = new SeparateChainingHashST<>();
        for (int i = 0; i < 100; i++) {
            st.put(i + "", i + "");
        }

        logger.info("{}", st.get("1"));
    }
}
