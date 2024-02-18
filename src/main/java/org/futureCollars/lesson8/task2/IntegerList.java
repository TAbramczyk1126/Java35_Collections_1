package org.futureCollars.lesson8.task2;

public class IntegerList implements OwnList {

    private static final int DEFAULT_SIZE = 10;

    private int size;

    private Integer[] tab1;

    public IntegerList() {
        this.tab1 = new Integer[DEFAULT_SIZE];
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
    }

    @Override
    public Integer get(int i) {
        return null;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer remove(int index) {
        return null;
    }
}
