package edu.unac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class PrimeNumbersTest {
    @Test
    void getPrimeNumbersInRange() {
        List<Integer> result = PrimeNumbers.getPrimeNumbersInRange(10,30);
        List<Integer> expected = List.of(11,13,17,19,23,29);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getPrimeNumbersInRangeLimits() {
        List<Integer> result = PrimeNumbers.getPrimeNumbersInRange(11,29);
        List<Integer> expected = List.of(11,13,17,19,23,29);

        Assertions.assertEquals(expected, result, "should include limited numbers");
    }

    @Test
    void getPrimeNumbersInRangeEmptyList() {
        List<Integer> result = PrimeNumbers.getPrimeNumbersInRange(90,96);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    void getPrimeNumbersInRangeLowerLimitNegative() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> PrimeNumbers.getPrimeNumbersInRange(-90,96)
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "lower limit cannot be negative";

        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void getPrimeNumbersInRangeLowerLimitGreaterUpperLimit() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> PrimeNumbers.getPrimeNumbersInRange(80,10)
        );

        String actualMessage = exception.getMessage();
        String expectedMessage = "lower limit cannot be greater than upper limit";

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}