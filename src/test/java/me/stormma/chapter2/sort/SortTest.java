package me.stormma.chapter2.sort;

import org.junit.Test;

/**
 * The {@code SortTest} test sort methods.
 */
public class SortTest {

    private static Integer[] a = {1, 14, 2, 13, 3, 12, 4, 11, 5, 10, 6, 9, 7, 8};

    @Test
    public void testSelectSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get("SelectSort"));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testInsertSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get("InsertSort"));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testBubbleSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get("BubbleSort"));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testShellSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get("ShellSort"));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testTopDownMergeSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get("MergeSortTD"));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testBottomTopMergeSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get("MergeSortBU"));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testQuickSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get("QuickSort"));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testQuickSort3Way() {
        SortUtils.sort(a, SortFactory.sortFactory.get("QuickSort3Way"));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testHeapSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get("HeapSort"));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }
}
