package org.futureCollars.lesson8.task2;

import java.util.Arrays;

public class IntegerList implements OwnList {

    private static final int DEFAULT_SIZE = 10;

    private int actualSize;

    private Integer[] array_int;

    public IntegerList() {
        this.array_int = new Integer[DEFAULT_SIZE];
        this.actualSize = 0;
    }

    @Override
    public int size() {
        return actualSize;
    }

    @Override
    public boolean isEmpty() {
        return actualSize == 0;
    }

    @Override
    public void add(Integer element) {
        ensureCapacity(actualSize + 1);
        array_int[actualSize++] = element;
    }

    @Override
    public Integer get(int i) {
        if (i < 0 || i >= actualSize) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Out of array size: " + actualSize);
        }
        return array_int[i];
    }

    @Override
    public void add(int index, Integer element) {
        if (index < 0 || index > actualSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Out of array sie: " + actualSize);
        }
        ensureCapacity(actualSize + 1);
        System.arraycopy(array_int, index, array_int, index + 1, actualSize - index);
        array_int[index] = element;
        actualSize++;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= actualSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", out of array size: " + actualSize);
        }
        Integer removedElement = array_int[index];
        System.arraycopy(array_int, index + 1, array_int, index, actualSize - index - 1);
        array_int[--actualSize] = null;
        return removedElement;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > array_int.length) {
            int newCapacity = array_int.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array_int = Arrays.copyOf(array_int, newCapacity);
        }
    }
}
