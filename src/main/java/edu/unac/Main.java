package edu.unac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> result = PrimeNumbers.getPrimeNumbersInRange(10,30);
        List<Integer> expected = List.of(11,13,17,19,23,29);
        assertEquals(expected, result, "Wrong prime numbers");

        result = PrimeNumbers.getPrimeNumbersInRange(11,29);
        assertEquals(expected, result, "No limits in numbers");

        result = PrimeNumbers.getPrimeNumbersInRange(90,96);
        assertEquals(Collections.emptyList(), result, "Empty list");




        boolean exceptionThrown = false;
        try {
            PrimeNumbers.getPrimeNumbersInRange(-90,96);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        if (!exceptionThrown) {
            throw new RuntimeException("Expected exception not thrown (lower limit is negative)");
        }

        exceptionThrown = false;
        try {
            PrimeNumbers.getPrimeNumbersInRange(30,10);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        if (!exceptionThrown) {
            throw new RuntimeException("Expected exception not thrown (lower limit is greater than upper limit)");
        }










    }


    private static void assertEquals(List<Integer> expected, List<Integer> actual, String message) {
        if (!actual.equals(expected)) {
            throw new RuntimeException(message + ", Expected " + expected + " but got " + actual);
        }
    }
}