package me.stormma.chapter1;

/**
 * This {@code ThreeSumFast} class is to solve three sum question.
 * <em>The three elements in the statistics array and the number of 0</em>
 *
 * @author stormma
 * @date 2017/10/18
 */
public class ThreeSumFast {

    public static int countThreeSum(Integer[] array) {
        int count = 0;
        BinarySearch<Integer> binarySearch = new BinarySearch<>(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int twoSum = array[i] + array[j];
                if (binarySearch.search(0 - twoSum) > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
