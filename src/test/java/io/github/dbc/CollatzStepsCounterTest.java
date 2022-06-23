package io.github.dbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CollatzStepsCounterTest {

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest(name = "countStepsToReachOne({0}) = {1}")
    @CsvSource(value = {
            "1,0", "2,1", "3,7", "4,2", "5,5", "6,8", "7,16", "8,3", "9,19", "10,6",
            "11,14", "12,9", "13,9", "14,17", "15,17", "16,4", "17,12", "18,20", "19,20", "20,7",
            "21,7", "22,15", "23,15", "24,10", "25,23", "26,10", "27,111", "28,18", "29,18", "30,18",
            "31,106", "32,5", "33,26", "34,13", "35,13", "36,21", "37,21", "38,21", "39,34", "40,8",
            "41,109", "42,8", "43,29", "44,16", "45,16", "46,16", "47,104", "48,11", "49,24", "50,24"
    })
    void countStepsToReachOne(int number, int expectedSteps) {
        CollatzStepsCounter collatzStepsCounter = new CollatzStepsCounter();
        int countedSteps = collatzStepsCounter.countStepsToReachOne(number);
        Assertions.assertEquals(expectedSteps, countedSteps);
    }

    @Test
    @DisplayName("a negative number should return Integer.MIN_VALUE")
    void countStepsToReachOneNegativeNumberReturnsMinusOne() {
        CollatzStepsCounter collatzStepsCounter = new CollatzStepsCounter();
        int countedSteps = collatzStepsCounter.countStepsToReachOne(-1);
        Assertions.assertEquals(Integer.MIN_VALUE, countedSteps);
    }
}