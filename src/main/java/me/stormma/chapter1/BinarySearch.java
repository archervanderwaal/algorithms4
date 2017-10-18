package me.stormma.chapter1;

import me.stormma.chapter2.sort.SortFactory;
import me.stormma.chapter2.sort.SortType;
import me.stormma.chapter2.sort.SortUtils;

/**
 * The {@code BinarySearch} class provides static method for quick search.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class BinarySearch<Data extends Comparable<Data>> {

    private Data[] data;

    public BinarySearch(Data[] data) {
        if (!SortUtils.isSorted(data)) {
            SortUtils.sort(data, SortFactory.sortFactory.get(SortType.HEAP_SORT));
        }
        this.data = data;
    }

    public int search(Data value) {
        int low = 0, high = data.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value.compareTo(data[mid]) < 0) {
                high = mid - 1;
            }
            if (value.compareTo(data[mid]) > 0) {
                low = mid + 1;
            }
            if (value.compareTo(data[mid]) == 0) {
                return mid;
            }
        }
        return -1;
    }
}
