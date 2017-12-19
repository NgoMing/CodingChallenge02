package com.minhnln.roundTable.utils;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class CircularlyListTest {
    private static final Object[] getCircularlyList() {
        return new Object[] {
                new Object[] {-1},
                new Object[] {1, 2, 3}
        };
    }

    // create arrays which use to test rotate method
    // utilise the first element as numOfStep param
    private static final Object[] getRotateArray() {
        return new Object[] {
                new Object[] {0, 1, 2, 3, 4},
                new Object[] {1, 2, 3, 4, 0},
                new Object[] {2, 3, 4, 0, 1},
                new Object[] {3, 4, 0, 1, 2},
                new Object[] {4, 0, 1, 2, 3}
        };
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void size(Integer[] array) throws Exception {
        CircularlyList<Integer> list = new CircularlyList<>(array);

        assertEquals(array.length, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    public void isEmpty() throws Exception {
        CircularlyList<Integer> emptyList = new CircularlyList<>();

        assertEquals(0, emptyList.size());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void getFirst(Integer[] array) throws Exception {
        CircularlyList<Integer> list = new CircularlyList<>(array);

        assertEquals(array[0], list.getFirst());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void getLast(Integer[] array) throws Exception {
        CircularlyList<Integer> list = new CircularlyList<>(array);

        assertEquals(array[array.length - 1], list.getLast());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void addFirst(Integer[] array) throws Exception {
        CircularlyList<Integer> list = new CircularlyList<>(array);
        list.addFirst(-5);

        assertEquals((Integer)(-5), list.getFirst());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void addLast(Integer[] array) throws Exception {
        CircularlyList<Integer> list = new CircularlyList<>(array);
        list.addLast(-5);

        assertEquals((Integer)(-5), list.getLast());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void removeFirst(Integer[] array) throws Exception {
        CircularlyList<Integer> list = new CircularlyList<>(array);

        assertEquals(array[0], list.removeFirst());
    }

    @Test
    public void removeFirstEmptyList() {
        CircularlyList<Integer> list = new CircularlyList<>();

        assertEquals(null, list.removeFirst());
    }

    @Test
    @Parameters(method = "getCircularlyList")
    public void toArray(Integer[] array) throws Exception {
        CircularlyList<Integer> list = new CircularlyList<>(array);

        assertArrayEquals(array, list.toArray());
    }

    @Test
    public void toArrayEmptyList() {
        CircularlyList<Integer> list = new CircularlyList<>();

        assertArrayEquals(null, list.toArray());
    }

    @Test
    @Parameters(method = "getRotateArray")
    public void rotate(Integer[] array) throws Exception {
        Integer[] initArray = {0, 1, 2, 3, 4};
        CircularlyList<Integer> list = new CircularlyList<>(initArray);

        // utilise the first element of array as numOfStep param
        list.rotate(array[0] + array.length);
        assertArrayEquals(array, list.toArray());
    }

    @Test
    public void rotateEmptyList() {
        CircularlyList<Integer> list = new CircularlyList<>();
        list.rotate(5);

        assertTrue(list.isEmpty());
    }

    @Test (expected = IllegalArgumentException.class)
    public void rotateNegativeParam() {
        CircularlyList<Integer> list = new CircularlyList<>(new Integer[]{1, 2, 3});
        list.rotate(-2);
    }
}