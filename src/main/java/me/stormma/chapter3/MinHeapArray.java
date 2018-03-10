package me.stormma.chapter3;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 最小堆数组实现
 * @author stormma
 * @date 2018/03/09
 */
public class MinHeapArray<E extends Comparable> implements Serializable {

    private static final Object[] DEFAULT_MIN_HEAP = {null};

    private transient Object[] es;

    private int capacity;

    private int size;

    public MinHeapArray() {
        this.es = DEFAULT_MIN_HEAP;
        this.size = 0;
        this.capacity = DEFAULT_MIN_HEAP.length;
    }

    public MinHeapArray(int initialCapacity) {
        if (initialCapacity > 0) {
            this.capacity = initialCapacity + 1;
            this.es = new Object[initialCapacity + 1];
        } else if (initialCapacity == 0) {
            this.es = DEFAULT_MIN_HEAP;
            this.size = 0;
            this.capacity = DEFAULT_MIN_HEAP.length;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public MinHeapArray(E[] es) {
        this(es.length + 1);
        this.size = es.length;
        System.arraycopy(es, 0, this.es, 1, this.size);
        for (int i = this.size / 2; i >= 1; i--) {
            sink(this.es, i);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return size;
    }

    public E popMin() {
        if (this.size == 0) return null;
        E e = (E) es[1];
        swap(this.es, 1, this.size);
        this.size--;
        sink(this.es, 1);
        return e;
    }

    public E min() {
        if (this.size == 0) return null;
        return (E) es[1];
    }

    public E add(E e) {
        if (e == null) throw new NullPointerException("Value cannot null " +
                                    e);
        if (this.capacity - this.size == 1) {
            grow(2 * this.capacity);
        }
        es[this.size + 1] = e;
        this.size++;
        swim(this.es, this.size);
        return e;
    }

    private void grow(int newCapacity) {
        this.es = Arrays.copyOf(this.es, newCapacity);
        this.capacity = newCapacity;
    }

    private void sink(Object[] a, int index) {
        while (2 * index <= this.size) {
            int leftI = 2 * index, rightI = leftI + 1, minI = leftI;
            if (leftI < this.size && ((Comparable)a[leftI]).compareTo((Comparable)a[rightI]) > 0) {
                minI = rightI;
            }
            if (((Comparable) a[index]).compareTo((Comparable) a[minI]) <= 0) break;
            swap(a, index, minI);
            index = minI;
        }
    }

    private void swim(Object[] a, int index) {
        while (index > 1) {
            int parentI = index / 2;
            if (((Comparable) a[parentI]).compareTo((Comparable) a[index]) < 0) {
                swap(a, parentI, index);
                index = parentI;
            } else {
                break;
            }
        }
    }

    private void swap(Object[] es, int i, int j) {
        Object tmp =  es[i];
        es[i] = es[j];
        es[j] = tmp;
    }
}
