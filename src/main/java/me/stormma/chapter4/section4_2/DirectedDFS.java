package me.stormma.chapter4.section4_2;

/**
 * 有向图的可达性
 * @author stormma
 * @date 2017/12/11
 */
public class DirectedDFS {

    private boolean[] marked;

    /**
     * 找出顶点s可达的顶点
     * @param G
     * @param s
     */
    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * 找出从sources的所有顶点可达的所有顶点
     * @param G
     * @param sources
     */
    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int s : sources) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph g, int s) {
        marked[s] = true;
        for (int w : g.adj(s)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
