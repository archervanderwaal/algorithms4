package me.stormma.chapter3;

import java.awt.event.ComponentAdapter;

/**
 * 哈夫曼树的实现
 * @author stormma
 * @date 2018/03/09
 */
public class HuffmanTree<E extends Comparable> {

    private MinHeapArray<Node> heap;

    private Node root;

    private static class Node<E extends Comparable> implements Comparable<Node> {
        E data;
        double weight;
        Node left;
        Node right;

        public Node(E data, double weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight > o.weight) {
                return 1;
            } else if (this.weight < o.weight) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public HuffmanTree(Node[] nodes) {
        heap = new MinHeapArray<>(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            heap.add(nodes[i]);
        }
        this.build();
    }

    private void build() {
        while (heap.size() > 1) {
            Node left = heap.popMin();
            Node right = heap.popMin();
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            heap.add(parent);
        }
        root = heap.min();
    }
}
