package me.stormma.chapter1;

import java.util.Iterator;

/**
 * This {@code Stack} class is implementation of the data structure 'Stack'
 *
 * @author stormma
 * @date 2017/10/18
 */
public class Stack<Data> implements Iterable<Data> {

    /** stack bottom element */
    private Node first;

    /** stack size */
    private int size;

    class Node {
        /** data */
        private Data data;

        /** next element */
        private Node next;

        public Node(Data data) {
            this.data = data;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Data data) {
        if (isEmpty()) {
            first = new Node(data);
            size++;
            return;
        }

        Node oldFirst = first;
        first = new Node(data);
        first.next = oldFirst;
        size++;
    }

    public Data pop() {
        if (isEmpty()) {
            return null;
        }
        Data data = first.data;
        first = first.next;
        size--;
        return data;
    }

    public Data peek() {
        if (isEmpty()) {
            return null;
        }
        return first.data;
    }

    @Override
    public Iterator<Data> iterator() {
        return new Iterator<Data>() {

            private Node currentNode = first;
            @Override
            public void remove() {

            }

            @Override
            public boolean hasNext() {
                return currentNode.next != null;
            }

            @Override
            public Data next() {
                Data data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }
}
