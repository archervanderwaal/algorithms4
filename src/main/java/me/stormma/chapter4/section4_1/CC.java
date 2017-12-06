package me.stormma.chapter4.section4_1;

/**
 * the implementation of connect component.
 * @author stormma
 * @date 2017/12/06
 */
public class CC {

    /** 标记数组*/
    private boolean[] marked;

    /** id数组*/
    private int[] id;

    /** 连通分量数*/
    private int count;

    public CC(Graph g, int v) {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for (int s = 0; s < g.V(); s++) {
            if (!marked[s]) {
                dfs(g, s);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
