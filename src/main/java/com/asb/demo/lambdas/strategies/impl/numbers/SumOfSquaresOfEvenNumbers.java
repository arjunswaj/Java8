package com.asb.demo.lambdas.strategies.impl.numbers;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Sum of squares of even numbers.
 * Created by arjun on 19/06/16.
 */
public class SumOfSquaresOfEvenNumbers
        extends SumOfSquares {

    @Override
    public Predicate<Integer> predicate() {
        return integer -> (integer == 0);
    }

    @Override
    public Function<Integer, Integer> baseCase() {
        return integer -> 1;
    }

    @Override
    public Function<Integer, Integer> decreaseOperation() {
        return integer -> (1 == integer % 2) ? integer - 1 :
                integer - 2;
    }

    @Override
    public BiFunction<Integer, Integer, Integer> recursiveCase() {
        return (result, number) -> (0 == number % 2) ?
                result + (number * number) : result;
    }

}
