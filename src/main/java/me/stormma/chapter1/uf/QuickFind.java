package me.stormma.chapter1.uf;

/**
 * This {@code QuickFind} class provides some methods to union-find.
 * <em>And the time complexity of find method is O(1), time complexity
 * of union method is O(n), so call it quick-find</em>
 *
 * @author stormma
 * @date 2017/10/18
 */
public class QuickFind {

    private int[] id;

    private int count;

    public QuickFind(int count) {
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
        return id[p];
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (find(i) == pRoot) {
                id[i] = qRoot;
            }
        }
        count--;
    }
}
