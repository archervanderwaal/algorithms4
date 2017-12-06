package me.stormma.chapter4.section4_1;

/**
 * @author stormma
 * @date 2017/12/06
 */
public class TwoColor {

    private boolean[] marked;

    private boolean[] color;

    private boolean isTwoColorable = true;

    public TwoColor(Graph g) {
        marked = new boolean[g.V()];
        color = new boolean[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) {
                dfs(g, s);
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(g, w);
            } else if (color[w] == color[v]) {
                isTwoColorable = false;
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
