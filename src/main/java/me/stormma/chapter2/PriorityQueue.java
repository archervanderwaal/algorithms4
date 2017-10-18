package me.stormma.chapter2;

/**
 * Priority Queue class
 *
 * @author
 * @date 2017/11/16
 */
public class PriorityQueue<Key extends Comparable<Key>> {

    private Key[] priorityQueue;

    private int count = 0;

    /**
     * init Key[] size, start with index 1==> 1, 2, 3, 4, 5...
     * @param maxN
     */
    @SuppressWarnings("unchecked")
    public PriorityQueue(int maxN) {
        priorityQueue = (Key[]) new Comparable[maxN + 1];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Key v) {
        priorityQueue[++count] = v;
        swim(count);
    }

    public Key delMax() {
        Key max = priorityQueue[1];
        exch(1, count--);
        priorityQueue[count + 1] = null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return priorityQueue[i].compareTo(priorityQueue[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = temp;
    }

    private void sink(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j < count && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }
}
