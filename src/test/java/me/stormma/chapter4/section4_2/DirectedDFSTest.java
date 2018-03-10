package me.stormma.chapter4.section4_2;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 有向图可达性测试用例
 * @author stormma
 * @date 2017/12/11
 */
public class DirectedDFSTest {

    private DirectedDFS dfs;

    static final int SIZE = 5;

    private static final Logger logger = LoggerFactory.getLogger(DirectedDFSTest.class);

    @Before
    public void init() {
        Digraph digraph = new Digraph(SIZE);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 1);
        digraph.addEdge(2, 3);
        digraph.addEdge(0, 3);
        digraph.addEdge(4, 5);
        dfs = new DirectedDFS(digraph, 0);
    }

    @Test
    public void testDFS() {
        for (int i = 0; i < SIZE; i++) {
            if (dfs.marked(i)) {
                logger.info("{}", i);
            }
        }
    }
}
