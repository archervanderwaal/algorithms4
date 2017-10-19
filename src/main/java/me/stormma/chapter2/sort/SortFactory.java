package me.stormma.chapter2.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code SortFactory} class provides some implementations of sort.
 *
 * @author stormma
 * @date 2017/10/18
 */
public class SortFactory {
	public static Map<SortType, Sort> sortFactory;

	static {
		sortFactory = new HashMap<>();
		sortFactory.put(SortType.SELECT_SORT, new SelectSort());
		sortFactory.put(SortType.BUBBLE_SORT, new BubbleSort());
		sortFactory.put(SortType.INSERT_SORT, new InsertSort());
		sortFactory.put(SortType.SHELL_SORT, new ShellSort());
		sortFactory.put(SortType.MERGE_SORT_TD, new MergeSortTD());
		sortFactory.put(SortType.MERGE_SORT_BU, new MergeSortBU());
		sortFactory.put(SortType.QUICK_SORT, new QuickSort());
		sortFactory.put(SortType.QUICK_SORT_THREE_WAY, new QuickSort3Way());
		sortFactory.put(SortType.HEAP_SORT, new HeapSort());
	}
}
