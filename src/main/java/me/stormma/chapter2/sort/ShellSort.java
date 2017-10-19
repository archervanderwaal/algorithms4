package me.stormma.chapter2.sort;

/**
 * This {@code ShellSort} class is implementation of shell sort.
 *
 * @author stormma
 * @date 2017/10/19
 */
public class ShellSort implements Sort {
    @Override
    public void sort(Comparable[] a) {
        //before shell sort
        System.out.print("before shell sort==>");
        SortUtils.show(a);
        int length = a.length;
        // 1, 4, 13, 40, 121...
        int gap = 1;
        int dis = 3;
        while (gap < length / dis) {
            gap = gap * dis + 1;
        }
        for (; gap > 0; gap /= dis) {
            for (int i = gap; i < length; i++) {
                for (int j = i; j >= gap && SortUtils.less(a[j], a[j-gap]); j -= gap) {
                    SortUtils.exch(a, j, j-gap);
                }
            }
        }
    }
}