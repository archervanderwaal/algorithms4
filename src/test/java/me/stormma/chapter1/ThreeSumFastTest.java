package me.stormma.chapter1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This {@code ThreeSumFastTest} class is in order to test {@ThreeSumFast} class.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class ThreeSumFastTest {

    private static final Logger logger = LoggerFactory.getLogger(ThreeSumFastTest.class);

    @Test
    public void testCountThreeSum() {
        Integer[] a = {-1, 9, -9, 8, -3, 1, 2, 3, -8, -2, -3, 10, 2, 3, -5};
        // 11
        logger.info("{}", ThreeSumFast.countThreeSum(a));
    }
}
