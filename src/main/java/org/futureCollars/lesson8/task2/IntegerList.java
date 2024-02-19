package org.futureCollars.lesson8.task2;

import java.util.Arrays;

public class IntegerList implements OwnList {

    private static final int DEFAULT_SIZE = 10;

    private int actualSize;

    private Integer[] intArray;

    public IntegerList() {
        this.intArray = new Integer[DEFAULT_SIZE];
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
        intArray[actualSize++] = element;
    }

    @Override
    public Integer get(int i) {
        if (i < 0 || i >= actualSize) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Out of array size: " + actualSize);
        }
        return intArray[i];
    }

    @Override
    public void add(int index, Integer element) {
        if (index < 0 || index > actualSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Out of array sie: " + actualSize);
        }
        ensureCapacity(actualSize + 1);
        System.arraycopy(intArray, index, intArray, index + 1, actualSize - index);
        intArray[index] = element;
        actualSize++;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= actualSize) {
            throw new IndexOutOfBoundsException("Index: " + index + ", out of array size: " + actualSize);
        }
        Integer removedElement = intArray[index];
        System.arraycopy(intArray, index + 1, intArray, index, actualSize - index - 1);
        intArray[--actualSize] = null;
        return removedElement;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > intArray.length) {
            int newCapacity = intArray.length * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            intArray = Arrays.copyOf(intArray, newCapacity);
        }
    }
}
