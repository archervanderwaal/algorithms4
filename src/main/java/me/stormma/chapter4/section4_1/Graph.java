package me.stormma.chapter4.section4_1;

import me.stormma.chapter1.Bag;

import java.util.Scanner;

/**
 * 无向图
 * @author stormma
 * @date 2017/10/26
 */
public class Graph {

    /** 顶点数量*/
    private final int V;

    /** 边的数量*/
    private int E;

    /** 邻接表数组*/
    private Bag<Integer> adj[];

    /**
     * 创建一个含有V个顶点但不含有边的图
     * @param v
     */
    public Graph(int v) {
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < this.V; i++) {
            adj[i] = new Bag<>();
        }
    }

    /**
     * 从标准输入读取初始化一个图, EX:
     * <code>
     *     12  # 顶点数
     *     12  # 边数
     *     1 2
     *     3 4
     *     ...
     * </code>
     * @param in
     */
    public Graph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        // 添加边
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            addEdge(v, w);
        }
    }

    /**
     * 返回顶点的数目
     * @return
     */
    public int V() {
        return this.V;
    }

    /**
     * 返回边的数目
     * @return
     */
    public int E() {
        return this.E;
    }

    /**
     * 添加一条边
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        if (v >= V || w >= V) {
            throw new NullPointerException("v and w must not be null!");
        }
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * 计算v的度数
     * @param v
     * @return
     */
    public int degree(int v) {
        if (v >= V) {
            throw new NullPointerException("v must not be null!");
        }
        return adj[v].size();
    }

    /**
     * 计算图中顶点最大度数
     * @return
     */
    public int maxDegree() {
        int max = 0;
        for (int i = 0;i < V; i++) {
            max = Math.max(adj[i].size(), max);
        }
        return max;
    }

    /**
     * 计算图平均度数
     * @return
     */
    public double avgDegree() {
        return 2.0 * this.V * this.E;
    }

    /**
     * 计算图中自环的个数
     * @return
     */
    public int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < V(); v++) {
            if (adj[v].contains(v)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 迭代器
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
