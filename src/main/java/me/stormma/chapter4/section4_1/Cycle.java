package me.stormma.chapter4.section4_1;

/**
 * @author stormma
 * @date 2017/12/06
 */
public class Cycle {

    private boolean[] marked;

    private boolean hasCycle;

    public Cycle(Graph g) {
        marked = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) {
                dfs(g, s, s);
            }
        }
    }

    private void dfs(Graph g, int v, int u) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w, v);
            } else if (w != u) {
                hasCycle = true;
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }
}
