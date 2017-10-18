package me.stormma.chapter2;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * sort Example class
 * 
 * @author stormma
 * @date 2017/11/16
 */
public class SortExample {

    private static Integer[] a = {1, 14, 2, 13, 3, 12, 4, 11, 5, 10, 6, 9, 7, 8};

	public static void main(String[] args) {

	}

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

interface Sort {
    /**
     * sort function
     * 
     * @param a Wait for sorted array.
     */
	void sort(Comparable[] a);
}

class SortUtils {

    public static final Logger logger = LoggerFactory.getLogger(SortUtils.class);

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
		show(a);
	}

	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}

	public static void sort(Comparable[] a, Sort sort) {
		sort.sort(a);
	}
}

class SortFactory {
	public static Map<String, Sort> sortFactory;

	static {
		sortFactory = new HashMap<>();
		sortFactory.put("SelectSort", new SelectSort());
		sortFactory.put("BubbleSort", new BubbleSort());
		sortFactory.put("InsertSort", new InsertSort());
		sortFactory.put("ShellSort", new ShellSort());
		sortFactory.put("MergeSortTD", new MergeSortTD());
		sortFactory.put("MergeSortBU", new MergeSortBU());
		sortFactory.put("QuickSort", new QuickSort());
		sortFactory.put("QuickSort3Way", new QuickSort3Way());
		sortFactory.put("HeapSort", new HeapSort());
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
