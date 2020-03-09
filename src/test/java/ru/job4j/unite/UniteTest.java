package ru.job4j.unite;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UniteTest {

    @Test
    public void whenUniteTwoSortedArraysThenOneSortedArray() {
        int[] a = {1, 3};
        int[] b = {2, 4};
        int[] result = new Unite().merge(a, b);
        int[] expected = {1, 2, 3, 4};
        assertThat(result, is(expected));
    }

    @Test
    public void whenUniteTwoSortedNotEqualArraysThenOneSortedArray() {
        int[] a = {0, 1, 2, 3, 8, 12};
        int[] b = {4, 5, 6, 7, 9, 10, 11, 13};
        int[] result = new Unite().merge(a, b);
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        assertThat(result, is(expected));
    }

    @Test
    public void whenUniteTwoSortedNotEqualArraysWithDoublesThenOneSortedArray() {
        int[] a = {0, 1, 2, 3, 8, 9, 12};
        int[] b = {1, 4, 5, 6, 7, 9, 10, 11, 13};
        int[] result = new Unite().merge(a, b);
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 11, 12, 13};
        assertThat(result, is(expected));
    }

    @Test
    public void whenUniteTwoArraysThenOneSortedArray() {
        int[] a = {5};
        int[] b = {2, 3};
        int[] result = new Unite().merge(a, b);
        int[] expected = {2, 3, 5};
        assertThat(result, is(expected));
    }
}