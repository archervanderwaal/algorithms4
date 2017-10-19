package me.stormma.chapter2.sort;

/**
 * This {@code QuickSort3Way} is implementation of quick sort three-way.
 *
 * @author stormma
 * @date 2017/10/19
 */
public class QuickSort3Way implements Sort {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int lt = low, i = low + 1, gt = high;
        Comparable v = a[low];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                SortUtils.exch(a, lt++, i++);
            } else if (cmp > 0) {
                SortUtils.exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);
    }
}
