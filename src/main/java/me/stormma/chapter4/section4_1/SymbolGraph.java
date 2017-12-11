package me.stormma.chapter4.section4_1;

import me.stormma.chapter3.section3_4.SeparateChainingHashST;

/**
 * the implementation of SymbolGraph
 * @author stormma
 * @date 2017/12/06
 */
public class SymbolGraph {

    private SeparateChainingHashST<String, Integer> st;

    private String[] keys;

    private Graph g;

    public SymbolGraph(String filename, String delim) {
        st = new SeparateChainingHashST<>();

    }

}
