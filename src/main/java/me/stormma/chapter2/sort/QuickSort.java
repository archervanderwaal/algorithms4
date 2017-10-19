package me.stormma.chapter2.sort;

/**
 * This {@code QuickSort} class is implementation of quick sort.
 *
 * @author stormma
 * @date 2017/10/19
 */
public class QuickSort implements Sort {

    @Override
    public void sort(Comparable[] a) {
        int length = a.length;
        sort(a, 0, length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private int partition(Comparable[] a, int low, int high) {
        int i = low, j = high + 1;
        Comparable value = a[low];
        while (true) {
            while (SortUtils.less(a[++i], value)) {
                if (i == high) {
                    break;
                }
            }
            while (SortUtils.less(value, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            SortUtils.exch(a, i, j);
        }
        SortUtils.exch(a, low, j);
        return j;
    }
}