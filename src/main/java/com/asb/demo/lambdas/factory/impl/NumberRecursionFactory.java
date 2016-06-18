package com.asb.demo.lambdas.factory.impl;

import com.asb.demo.lambdas.factory.RecursionFactory;
import com.asb.demo.lambdas.recursion.NumberRecursionTypes;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Number Recursion Factory.
 * Created by arjun on 18/06/16.
 */
public class NumberRecursionFactory
        implements RecursionFactory<Integer, Integer, NumberRecursionTypes> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Integer> predicate(
            NumberRecursionTypes numberRecursionTypes) {
        Predicate<Integer> predicate = null;
        switch (numberRecursionTypes) {
            case FACTORIAL:
            case SUMMATION:
            case SUM_OF_SQUARES:
            case SUM_OF_SQUARES_OF_ODD_NUMBERS:
                predicate = integer -> (integer == 1);
                break;
            case SUM_OF_SQUARES_OF_EVEN_NUMBERS:
                predicate = integer -> (integer == 0);
                break;
        }
        return predicate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Function<Integer, Integer> baseCase(
            NumberRecursionTypes numberRecursionTypes) {
        Function<Integer, Integer> baseCase = null;
        switch (numberRecursionTypes) {
            case FACTORIAL:
            case SUMMATION:
            case SUM_OF_SQUARES:
            case SUM_OF_SQUARES_OF_ODD_NUMBERS:
                baseCase = integer -> 1;
                break;
            case SUM_OF_SQUARES_OF_EVEN_NUMBERS:
                baseCase = integer -> 0;
                break;
        }
        return baseCase;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Function<Integer, Integer> valueOperator(
            NumberRecursionTypes numberRecursionTypes) {
        Function<Integer, Integer> valueOperator = null;
        switch (numberRecursionTypes) {
            case FACTORIAL:
            case SUMMATION:
            case SUM_OF_SQUARES:
                valueOperator = integer -> integer - 1;
                break;
            case SUM_OF_SQUARES_OF_ODD_NUMBERS:
                valueOperator = integer -> (0 == integer % 2) ? integer - 1 :
                        integer - 2;
                break;
            case SUM_OF_SQUARES_OF_EVEN_NUMBERS:
                valueOperator = integer -> (1 == integer % 2) ? integer - 1 :
                        integer - 2;
                break;
        }
        return valueOperator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BiFunction<Integer, Integer, Integer> recursiveCase(
            NumberRecursionTypes numberRecursionTypes) {
        BiFunction<Integer, Integer, Integer> recursiveCase = null;
        switch (numberRecursionTypes) {
            case FACTORIAL:
                recursiveCase = (result, number) -> result * number;
                break;
            case SUMMATION:
                recursiveCase = (result, number) -> result + number;
                break;
            case SUM_OF_SQUARES:
                recursiveCase = (result, number) -> result + (number * number);
                break;
            case SUM_OF_SQUARES_OF_ODD_NUMBERS:
                recursiveCase = (result, number) -> (1 == number % 2) ?
                        result + (number * number) : result;
                break;
            case SUM_OF_SQUARES_OF_EVEN_NUMBERS:
                recursiveCase = (result, number) -> (0 == number % 2) ?
                        result + (number * number) : result;
                break;
        }
        return recursiveCase;
    }
}
