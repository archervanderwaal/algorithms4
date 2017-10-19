package me.stormma.chapter2;

import me.stormma.chapter2.sort.SortUtils;

import java.util.Scanner;

/**
 * 荷兰过期问题(leet code set colors)
 *
 * @author stormma
 * @date 2017/10/19
 */
public class SortColors {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Integer[] array = new Integer[count];
        for (int i = 0; i < count; i++) {
            array[i] = in.nextInt();
        }
        sort(array);
        SortUtils.show(array);
    }

    private static void sort(Integer[] array) {
        //0区开始位置，2区开始位置length - 1
        int pos0 = 0, pos2 = array.length - 1, currentPos = 0;
        while (currentPos <= pos2) {
            if (array[currentPos] == 0) {
                SortUtils.exch(array, pos0, currentPos);
                pos0++;
                currentPos++;
                continue;
            }
            if (array[currentPos] == 2) {
                SortUtils.exch(array, currentPos, pos2);
                pos2--;
                continue;
            }
            currentPos++;
        }
    }
}
