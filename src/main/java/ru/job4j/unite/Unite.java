package ru.job4j.unite;

/**
 * Class Unite, .
 *
 * @author Yury Doronin (doronin.ltd@gmail.com)
 * @version 1.0
 * @since 05.04.2019
 */
public class Unite {

    /**
     * Merging two sorted arrays in one sorted array.
     *
     * @param left,  an array.
     * @param right, an array.
     * @return int[], a new array.
     */
    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        for (int index = 0; index < result.length; index++) {
            if (j == right.length || i < left.length && left[i] <= right[j]) {
                result[index] = left[i++];
            } else {
                result[index] = right[j++];
            }
        }
        return result;
    }
}
