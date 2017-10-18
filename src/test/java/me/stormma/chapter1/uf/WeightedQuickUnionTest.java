package me.stormma.chapter1.uf;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * This {@code WeightedQuickUnionTest} class is in order to test {@code WeightedQuickUnion} class.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class WeightedQuickUnionTest {

    private static final Logger logger = LoggerFactory.getLogger(WeightedQuickUnionTest.class);

    @Test
    public void test() throws IOException {
        URL tinyUF = new URL("http://algs4.cs.princeton.edu/15uf/largeUF.txt");
        InputStream inputStream = tinyUF.openConnection().getInputStream();
        Scanner scanner = new Scanner(inputStream);
        int N = scanner.nextInt();
        WeightedQuickUnion qu = new WeightedQuickUnion(N);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (qu.connected(p, q)) {
                continue;
            }
            qu.union(p, q);
            logger.info("union components {} and {}", p, q);
        }
        logger.info("{} components", qu.count());
    }
}
