package me.stormma.chapter1;

import java.util.Iterator;

/**
 * This {@code Queue} class is implementation of the data structure 'Queue'
 *
 * @author stormma
 * @date 2017/10/18
 */
public class Queue<Data> implements Iterable<Data> {

    private Node first;

    private Node last;

    private int size;

    class Node {

        private Data data;

        private Node next;

        public Node(Data data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public Data enqueue(Data data) {
        Node oldLast = last;
        last = new Node(data);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
        return data;
    }

    public Data dequeue() {
        Data data = first.data;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        size--;
        return data;
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
                return currentNode != null;
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
