package me.stormma.chapter4.section4_1;

import me.stormma.chapter1.Stack;

/**
 * @author stormma
 * @date 2017/12/06
 */
public class DepthFirstPaths {

    /** 标记数组*/
    private boolean[] marked;

    /** 起点到顶点的已知路径上的最后一个顶点*/
    private int[] edgeTo;

    /** 起点*/
    private final int s;

    public DepthFirstPaths(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))  return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
