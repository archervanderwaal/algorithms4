package me.stormma.chapter1.uf;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

/**
 * This {@QuickUnionTest} class is in order to test {@QuickUnion} class.
 * the data of test on 'http://algs4.cs.princeton.edu/15uf/tinyUF.txt'.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class QuickUnionTest {

    private static final Logger logger = LoggerFactory.getLogger(QuickUnionTest.class);

    @Test
    public void test() throws IOException {
        URL tinyUF = new URL("http://algs4.cs.princeton.edu/15uf/tinyUF.txt");
        InputStream inputStream = tinyUF.openConnection().getInputStream();
        Scanner scanner = new Scanner(inputStream);
        int N = scanner.nextInt();
        QuickUnion qu = new QuickUnion(N);
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
        // test result
        /*
         22:21:10.934 [main] INFO  me.stormma.chapter1.uf.QuickUnionTest - union components 4 and 3
         22:21:10.942 [main] INFO  me.stormma.chapter1.uf.QuickUnionTest - union components 3 and 8
         22:21:10.942 [main] INFO  me.stormma.chapter1.uf.QuickUnionTest - union components 6 and 5
         22:21:10.942 [main] INFO  me.stormma.chapter1.uf.QuickUnionTest - union components 9 and 4
         22:21:10.942 [main] INFO  me.stormma.chapter1.uf.QuickUnionTest - union components 2 and 1
         22:21:10.942 [main] INFO  me.stormma.chapter1.uf.QuickUnionTest - union components 5 and 0
         22:21:10.943 [main] INFO  me.stormma.chapter1.uf.QuickUnionTest - union components 7 and 2
         22:21:10.943 [main] INFO  me.stormma.chapter1.uf.QuickUnionTest - union components 6 and 1
         22:21:10.943 [main] INFO  me.stormma.chapter1.uf.QuickUnionTest - 2 components
         */
    }
}
