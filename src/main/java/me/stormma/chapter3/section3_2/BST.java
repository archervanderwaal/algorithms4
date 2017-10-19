package me.stormma.chapter3.section3_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * implementation of binary search tree.
 * @author stormma
 * @date 2017/11/18
 */
public class BST<Key extends Comparable<Key>, Value> {

    /**
     * root node
     */
    private Node root;

    private class Node {
        /**
         * node key
         */
        private Key key;

        /**
         * node value
         */
        private Value value;

        /**
         * left, right subtree
         */
        private Node left, right;

        /**
         * The total number of nodes of the subtree with root as the root node
         */
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        }
        if (cmp > 0) {
            return get(node.right, key);
        }
        return node.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key max() {
        Node node = max(root);
        return node == null ? null : node.key;
    }

    private Node max(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return max(max(node.right));
    }

    public Key min() {
        Node node = min(root);
        return node == null ? null : node.key;
    }

    private Node min(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        return node == null ? null : node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp < 0) {
            return floor(node.left, key);
        }
        Node t = floor(node.right, key);
        if (t != null) {
            return t;
        }
        return node;
    }

    public Key ceil(Key key) {
        Node node = ceil(root, key);
        return node == null ? null : node.key;
    }

    private Node ceil(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        }
        if (cmp > 0) {
            return ceil(node.right, key);
        }
        Node t = ceil(node.left, key);
        if (t != null) {
            return t;
        }
        return node;
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) {
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(node.left, key);
        }
        if (cmp > 0) {
            return size(node.left) + 1 + rank(node.right, key);
        }
        return size(node.left);
    }

    public Key select(int rank) {
        Node node = select(root, rank);
        return node == null ? null : node.key;
    }

    private Node select(Node node, int rank) {
        if (node == null) {
            return null;
        }
        int leftSize = size(node.left);
        if (rank < leftSize) {
            return select(node.left, rank);
        }
        if (rank > leftSize) {
            return select(node.right, rank - leftSize - 1);
        }
        return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node == null) {
            return null;
        }
        // remove node x
        if (node.left == null) {
            return node.right;
        }
        // update node's left child
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    public Node deleteMax(Node node) {
        // if size == 0 && root == null, return null
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }
            Node toDelete = node;
            node = min(toDelete.right);
            node.right = deleteMin(toDelete.right);
            node.left = toDelete.left;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key low, Key high) {
        List<Key> keyList = new ArrayList<>();
        keys(root, keyList, low, high);
        return keyList;
    }

    private void keys(Node node, List<Key> keyList, Key low, Key high) {
        if (node == null) {
            return;
        }
        int cmpLow = low.compareTo(node.key);
        int cmpHigh = high.compareTo(node.key);
        if (cmpLow < 0) {
            keys(node.left, keyList, low, high);
        }
        if (cmpLow <= 0 && cmpHigh >= 0) {
            keyList.add(node.key);
        }
        if (cmpHigh > 0) {
            keys(node.right, keyList, low, high);
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public void levelOrder() {

    }

    private void levelOrder(Node node) {

    }
}
