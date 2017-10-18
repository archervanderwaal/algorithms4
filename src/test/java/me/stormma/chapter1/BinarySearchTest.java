package me.stormma.chapter1;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author stormma
 * @date 2017/10/18
 */
public class BinarySearchTest {

    private static final Logger logger = LoggerFactory.getLogger(BinarySearchTest.class);

    private static BinarySearch<Character> bs;

    @Before
    public void init() {
        Character[] characters = new Character[5];
        characters[0] = 'A';
        characters[1] = 'B';
        characters[2] = 'C';
        characters[3] = 'D';
        characters[4] = 'E';
        bs = new BinarySearch<>(characters);
    }

    @Test
    public void testSearch() {
        // 3
        logger.info("the index of element 'D' is: {}", bs.search('D'));
        // -1
        logger.info("the index of element 'F' is: {}", bs.search('F'));
    }
}
