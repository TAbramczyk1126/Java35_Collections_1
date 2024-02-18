package org.futureCollars.lesson8.task2;

import java.util.Arrays;

public class IntegerList implements OwnList {

    private static final int DEFAULT_SIZE = 10;

    private int size;

    private Integer[] array_int;

    public IntegerList() {
        this.array_int = new Integer[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(Integer element) {
        ensureCapacity(size + 1);
        array_int[size++] = element;
    }

    @Override
    public Integer get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return array_int[i];
    }

    @Override
    public void add(int index, Integer element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(array_int, index, array_int, index + 1, size - index);
        array_int[index] = element;
        size++;
    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Integer removedElement = array_int[index];
        System.arraycopy(array_int, index + 1, array_int, index, size - index - 1);
        array_int[--size] = null;
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