package me.stormma.chapter2.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code SortFactory} class provides some sort types.
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

	static class SelectSort implements Sort {
		@Override
		public void sort(Comparable[] a) {
			int length = a.length;
			for (int i = 0; i < length; i++) {
				int min = i;
				for (int j = i + 1; j < length; j++) {
					if (SortUtils.less(a[j], a[min])) {
						min = j;
					}
				}
				if (min != i) {
					SortUtils.exch(a, i, min);
				}
			}
		}
	}

	static class InsertSort implements Sort {
		@Override
		public void sort(Comparable[] a) {
			int length = a.length;
			for (int i = 1; i < length; i++) {
				for (int j = i; j > 0 && SortUtils.less(a[j], a[j-1]); j--) {
					SortUtils.exch(a, j, j-1);
				}
			}
		}
	}

	static class BubbleSort implements Sort {
		@Override
		public void sort(Comparable[] a) {
			int length = a.length;
			for (int i = 0; i < length - 1; i++) {
				for (int j = 0; j < length - 1 - i; j++) {
					if (!SortUtils.less(a[j], a[j+1])) {
						SortUtils.exch(a, j, j+1);
					}
				}
			}
		}
	}

	/**
	 * <div id="shell_sort"></div>
	 */
	static class ShellSort implements Sort {
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

	static class MergeSortTD implements Sort {

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
			int mid = low + (high - low) / 2;
			sort(a, low, mid);
			sort(a, mid + 1, high);
			merge(a, low, mid, high);
		}

		private static void  merge(Comparable[] a, int low, int mid, int high) {
			int i = low, j = mid + 1;
			for (int k = low; k <= high; k++) {
				aux[k] = a[k];
			}
			for (int k = low; k <= high; k++) {
				if (i <= mid && j <= high) {
					a[k] = SortUtils.less(aux[i], aux[j]) ? aux[i++] : aux[j++];
				} else if (i > mid) {
					a[k] = aux[j++];
				} else if (j > high) {
					a[k] = aux[i++];
				}
			}
		}
	}

	static class MergeSortBU implements Sort {
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
			int i = low, j = mid + 1;
			for (int k = low; k <= high; k++) {
				aux[k] = a[k];
			}
			for (int k = low; k <= high; k++) {
				if (i <= mid && j <= high) {
					a[k] = SortUtils.less(aux[i], aux[j]) ? aux[i++] : aux[j++];
				} else if (i > mid) {
					a[k] = aux[j++];
				} else if (j > high) {
					a[k] = aux[i++];
				}
			}
			System.out.println("Merge result: ");
			SortUtils.show(a);
		}
	}

	static class QuickSort implements Sort {

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

	static class QuickSort3Way implements Sort {
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

    static class HeapSort implements Sort {
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
}
