package me.stormma.chapter2.sort;

/**
 * This {@code MergeSortTD} is implementation of merge sort top-down
 *
 * @author stormma
 * @date 2017/10/19
 */
public class MergeSortTD implements Sort {

    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + ((high - low) >> 1);
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private static void  merge(Comparable[] a, int low, int mid, int high) {
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
    }
}
