package me.stormma.chapter4.section4_1;

/**
 * 图的深度优先搜索(dfs)
 * @author stormma
 * @date 2017/10/26
 */
public class DepthFirstSearch {

    private boolean[] marked;

    private int count;

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int w: g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public int count() {
        return count;
    }
}
