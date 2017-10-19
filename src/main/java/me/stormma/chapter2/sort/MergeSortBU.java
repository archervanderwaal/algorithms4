package me.stormma.chapter2.sort;

/**
 * This {@code MergeSortBU} class is implementation of merge sort bottom-up
 *
 * @author stormma
 * @date 2017/10/19
 */
public class MergeSortBU implements Sort {
    private static Comparable[] aux;
    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        int length = a.length;
        int step = 2;
        for (int sz = 1; sz < length; sz += sz) {
            for (int lo = 0; lo < length - sz; lo += step * sz) {
                System.out.println(sz);
                merge(a, lo, lo + sz - 1, Math.min(lo + step * sz - 1, length - 1) );
            }
        }
    }

    private static void  merge(Comparable[] a, int low, int mid, int high) {
        System.out.println("Starting => merge(a, " + low + ", " + mid + ", " + high + ")");
        int start1 = low, start2 = mid + 1;
        System.arraycopy(a, low, aux, low, high + 1 - low);
        for (int k = low; k <= high; k++) {
            if (start1 <= mid && start2 <= high) {
                a[k] = SortUtils.less(aux[start1], aux[start2]) ? aux[start1++] : aux[start2++];
            } else if (start1 > mid) {
                a[k] = aux[start2++];
            } else if (start2 > high) {
                a[k] = aux[start1++];
            }
        }
        System.out.println("Merge result: ");
        SortUtils.show(a);
    }
}