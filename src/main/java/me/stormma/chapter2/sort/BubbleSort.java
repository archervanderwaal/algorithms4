package me.stormma.chapter2.sort;

/**
 * This {@code BubbleSort} class is implementation of bubble sort.
 *
 * @author stormma
 * @date 2017/10/19
 */
public class BubbleSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (!SortUtils.less(a[j], a[j+1])) {
                    SortUtils.exch(a, j, j+1);
                }
            }
        }
    }
}