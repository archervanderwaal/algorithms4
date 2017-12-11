package me.stormma.chapter4.section4_2;

import me.stormma.chapter1.Bag;

/**
 * 有向图定义
 * @author stormma
 * @date 2017/12/11
 */
public class Digraph {

    private final int V;

    private int E;

    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        this.E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph digraph = new Digraph(this.V);
        for (int v = 0; v < this.V; v++) {
            for (int w : adj(v)) {
                digraph.addEdge(w, v);
            }
        }
        return digraph;
    }
}
