package org.futureCollars.lesson8.task2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListTest {

    private OwnList integerList;

    @BeforeEach
    void setUp() {
        integerList = new IntegerList();
    }

    @ParameterizedTest
    @CsvSource({"0, 5", "1, 10", "2, 15"})
    void testGet(int index, int expectedValue) {
        integerList.add(5);
        integerList.add(10);
        integerList.add(15);
        assertEquals(expectedValue, integerList.get(index));
    }

    @ParameterizedTest
    @CsvSource({"3, 5, 1, 7, 4"})
    void shouldAddValueAndCheckSize(int value1, int value2, int value3, int value4, int expectedSize) {
        //when
        integerList.add(value1);
        integerList.add(value2);
        integerList.add(value3);
        integerList.add(value4);
        //then
        assertEquals(expectedSize, integerList.size());
    }

    @ParameterizedTest
    @CsvSource({"0, 5", "1, 10", "2, 15", "3, 18"})
    void testRemove(int index, int expectedValue) {
        //given
        integerList.add(5);
        integerList.add(10);
        integerList.add(15);
        integerList.add(18);
        //when
        int removedValue = integerList.remove(index);
        //then
        assertEquals(expectedValue, removedValue);
        assertEquals(3, integerList.size());
    }
}
