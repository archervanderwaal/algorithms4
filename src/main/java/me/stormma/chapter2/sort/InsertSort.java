package me.stormma.chapter2.sort;

/**
 * This {@code InsertSort} class is implementation of insert sort.
 *
 * @author stormma
 * @date 2017/10/19
 */
public class InsertSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && SortUtils.less(a[j], a[j-1]); j--) {
                SortUtils.exch(a, j, j-1);
            }
        }
    }
}
