package me.stormma.chapter3;

import org.junit.Before;
import org.junit.Test;

/**
 * 测试最小堆
 * @author stormma
 * @date 2018/03/09
 */
public class MinHeapTest {

    private static Integer[] a = {3, 8, 9, 1, 2, 3, 4, 5, 0, 8, 9, 11, 10000};

    private static MinHeapArray<Integer> heap;

    @Before
    public void init() {
        heap = new MinHeapArray<>(a);
    }

    @Test
    public void testMin() {
//        while (!heap.isEmpty()) {
//            System.out.print(heap.popMin() + " ");
//        }
        int size = heap.size();
        for (int i = 0; i < size; i++) {
            System.out.print(heap.popMin() + " ");
        }
    }
}
