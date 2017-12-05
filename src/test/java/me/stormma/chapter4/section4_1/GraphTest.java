package me.stormma.chapter4.section4_1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * @author stormma
 * @date 2017/12/05
 */
public class GraphTest {

    private static final Logger logger = LoggerFactory.getLogger(GraphTest.class);

    @Test
    public void testInitGraph() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Graph graph = new Graph(in);
        logger.info("V: {}", graph.V());
        logger.info("E: {}", graph.E());
    }
}
