package me.stormma.chapter2.sort;

import org.junit.Test;

/**
 * The {@code SortTest} test sort methods.
 */
public class SortTest {

    private static Integer[] a = {1, 14, 2, 13, 3, 12, 4, 11, 5, 10, 6, 9, 7, 8};

    @Test
    public void testSelectSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get(SortType.SELECT_SORT));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testInsertSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get(SortType.INSERT_SORT));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testBubbleSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get(SortType.BUBBLE_SORT));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testShellSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get(SortType.SHELL_SORT));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testTopDownMergeSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get(SortType.MERGE_SORT_TD));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testBottomTopMergeSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get(SortType.MERGE_SORT_BU));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testQuickSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get(SortType.QUICK_SORT));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testQuickSort3Way() {
        SortUtils.sort(a, SortFactory.sortFactory.get(SortType.QUICK_SORT_THREE_WAY));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }

    @Test
    public void testHeapSort() {
        SortUtils.sort(a, SortFactory.sortFactory.get(SortType.HEAP_SORT));
        assert SortUtils.isSorted(a);
        SortUtils.show(a);
    }
}
