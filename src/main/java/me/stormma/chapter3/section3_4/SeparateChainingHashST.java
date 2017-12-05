package me.stormma.chapter3.section3_4;

import me.stormma.chapter3.section3_1.SequentialSearchST;

/**
 * use hash table.
 * @author stormma
 * @date 2017/10/25
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;

    private int M;

    private SequentialSearchST<Key, Value>[] sts;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int m) {
        this.M = m;
        sts = (SequentialSearchST<Key, Value>[])new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            sts[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return sts[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        sts[hash(key)].put(key, value);
    }
}
