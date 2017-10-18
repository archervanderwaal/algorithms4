package me.stormma.chapter1.uf;

/**
 * This {@QuickUnion} class provides provides some methods to union-find.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class QuickUnion {

    private int[] id;

    private int count;

    public QuickUnion(int count) {
        this.count = count;
        id = new int[count];
        // Initialize the component
        for (int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = id[qRoot];
        count--;
    }
}
