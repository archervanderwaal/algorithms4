package me.stormma.chapter1.uf;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * This {@code PathCompressionWeightedQuickUnionTest} class is in order to test
 *                          {@code PathCompressionWeightedQuickUnion} class.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class PathCompressionWeightedQuickUnionTest {

    private static final Logger logger = LoggerFactory.getLogger(PathCompressionWeightedQuickUnionTest.class);

    @Test
    public void test() throws IOException {
        URL tinyUF = new URL("http://algs4.cs.princeton.edu/15uf/largeUF.txt");
        InputStream inputStream = tinyUF.openConnection().getInputStream();
        Scanner scanner = new Scanner(inputStream);
        int N = scanner.nextInt();
        PathCompressionWeightedQuickUnion pwqu = new PathCompressionWeightedQuickUnion(N);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (pwqu.connected(p, q)) {
                continue;
            }
            pwqu.union(p, q);
            logger.info("union components {} and {}", p, q);
        }
        logger.info("{} components", pwqu.count());
    }
}