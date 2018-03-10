package me.stormma.chapter4.section4_2;

import me.stormma.chapter1.Stack;

/**
 * 寻找有向环问题
 * @author stormma
 * @date 2017/12/11
 */
public class DirectedCycle {

    /** 标记数组*/
    private boolean[] marked;

    /** */
    private int[] edgeTo;

    /** 有向环中的所有顶点，如果存在*/
    private Stack<Integer> cycle;

    /** 递归调用栈上的所有顶点*/
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph g, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    private boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
