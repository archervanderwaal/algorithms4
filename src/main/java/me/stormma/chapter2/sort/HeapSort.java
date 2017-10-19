package me.stormma.chapter2.sort;

/**
 * This {@code HeapSort} class is implementation of heap sort.
 *
 * @author stormma
 * @date 2017/10/19
 */
public class HeapSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length - 1;
        //构造最大堆
        for (int k = (N - 1) / 2; k >= 0; k--) {
            sink(a, k, N);
        }
        SortUtils.show(a);
        while (N > 0) {
            SortUtils.exch(a, 0, N--);
            sink(a, 0, N);
        }
    }

    private void sink(Comparable[] a, int index, int N) {
        //left sub tree lt N
        while ((2 * index + 1) <= N) {
            int leftI = 2 * index + 1;
            int maxI = leftI, rightI = leftI + 1;
            if (leftI < N && SortUtils.less(a[leftI], a[rightI])) {
                maxI = rightI;
            }
            if (!SortUtils.less(a[index], a[maxI])) {
                break;
            }
            SortUtils.exch(a, index, maxI);
            index = maxI;
        }
    }
}