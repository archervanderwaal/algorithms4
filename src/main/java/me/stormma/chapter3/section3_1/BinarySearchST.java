package me.stormma.chapter3.section3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author stormma
 * @date 2017/10/17
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    /**
     * keys
     */
    private Key[] keys;

    /**
     * values
     */
    private Value[] values;

    private int size;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    private int rank(Key key) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp == 0) {
                return mid;
            }
            high = cmp < 0 ? mid - 1 : high;
            low = cmp > 0 ? mid + 1 : low;
        }
        return low;
    }

    public void put(Key key, Value value) {
        int insertI = rank(key);
        // update
        if (insertI < size && key.compareTo(keys[insertI]) == 0) {
            values[insertI] = value;
            return;
        }
        // move other key & value
        for (int i = size; i > insertI; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        // insert new key & value
        keys[insertI] = key;
        values[insertI] = value;
        // increase size
        size++;
        assert check();
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int getI = rank(key);
        if (getI < size && key.compareTo(keys[getI]) == 0) {
            return values[getI];
        }
        return null;
    }

    public Value delete(Key key) {
        if (isEmpty()) {
            return null;
        }
        int deleteI = rank(key);
        if (deleteI < size && key.compareTo(keys[deleteI]) == 0) {
            // move other key & value
            Value deleteValue = values[deleteI];
            for (int i = deleteI; i < size - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            // decrease size and set keys[size] = null, values[size] = null (at this time. size = size - 1)
            size--;
            keys[size] = null;
            values[size] = null;
            assert check();
            return deleteValue;
        }
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[size - 1];
    }

    public Key select(int index) {
        return keys[index];
    }

    public Key ceiling(Key key) {
        // eg: 1 4 5 7 => if key = 3, return 4 || if key = 4 return 4
        return keys[rank(key)];
    }

    public Key floor(Key key) {
        // eg: 1 4 5 7 => if key = 3, return keys[1-1] = 1 || if key = 0 return null
        int insertI = rank(key);
        if (insertI < size) {
            if (key.compareTo(keys[insertI]) == 0) {
                return keys[insertI];
            }
            if (insertI > 0) {
                return keys[insertI - 1];
            }
        }
        return null;
    }

    /**
     * get keys between low ~ high and include low, non_include high
     * @param low
     * @param high
     * @return
     */
    public Iterable<Key> keys(Key low, Key high) {
        List<Key> keyList = new ArrayList<>();
        keyList.addAll(Arrays.asList(keys).subList(rank(low), rank(high)));
        return keyList;
    }

    public Iterable<Key> keys() {
        List<Key> keyList = (List<Key>) keys(min(), max());
        if (!keyList.contains(max())) {
            keyList.add(max());
        }
        return keyList;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value deleteMin() {
        return delete(min());
    }

    public Value deleteMax() {
        return delete(max());
    }

    private boolean isSorted() {
        for (int i = 1; i < size; i++) {
            if (keys[i].compareTo(keys[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean rankCheck() {
        for (int i = 0; i < size; i++) {
            if (i != rank(select(i)) || keys[i].compareTo(select(rank(keys[i]))) != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean check() {
        return isSorted() && rankCheck();
    }
}
