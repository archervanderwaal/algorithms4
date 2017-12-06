package me.stormma.chapter4.section4_1;

import me.stormma.chapter1.Queue;

import java.util.Stack;

/**
 * alg 4th the implementation of BFS
 * @author stormma
 * @date 2017/12/06
 */
public class BreadthFirstSearch {

    /** 标记数组*/
    private boolean[] marked;

    /** 到达该顶点的已知路径上的最后一个顶点*/
    private int[] edgeTo;

    /** 起点*/
    private final int s;

    public BreadthFirstSearch(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new Queue<>();
        //  mark it
        marked[s] = true;
        // enqueue
        queue.enqueue(s);
        // if not empty
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : g.adj(v)) {
                // if not marked
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
