package me.stormma.chapter2.sort;

/**
 * This {@code SelectSort} class is implementation of select sort.
 *
 * @author stormma
 * @date 2017/10/19
 */
public class SelectSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (SortUtils.less(a[j], a[min])) {
                    min = j;
                }
            }
            if (min != i) {
                SortUtils.exch(a, i, min);
            }
        }
    }
}
