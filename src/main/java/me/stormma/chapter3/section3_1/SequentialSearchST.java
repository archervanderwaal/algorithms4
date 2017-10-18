package me.stormma.chapter3.section3_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SequentialSearchST<Key, Value> {

    private Node first;

    private int size = 0;

    private class Node {

        Key key;

        Value value;

        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        size++;
    }

    public int size() {
        return size;
    }

    public Iterable<Key> keys() {
        List<Key> keys = new ArrayList<Key>();
        for (Node x = first; x != null; x = x.next) {
            keys.add(x.key);
        }
        return keys;
    }

    public Node delete(Key key) {
        Node preNode = null;
        for (Node x = first; x != null; x = x.next) {
            // remove node x
            if (x.key.equals(key)) {
                size--;
                if (preNode == null) {
                    // wait gc collection
                    first.next = null;
                    first = x.next;
                } else {
                    // wait gc collection
                    x.next = null;
                    preNode.next = x.next;
                }
                return x;
            }
            preNode = x;
        }
        return null;
    }
}
