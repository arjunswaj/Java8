package com.asb.demo.lambdas.strategies.impl.numbers;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Sum of squares of odd numbers.
 * Created by arjun on 19/06/16.
 */
public class SumOfSquaresOfOddNumbers extends SumOfSquares {

    @Override
    public Function<Integer, Integer> valueOperator() {
        return integer -> (0 == integer % 2) ? integer - 1 :
                integer - 2;
    }

    @Override
    public BiFunction<Integer, Integer, Integer> recursiveCase() {
        return (result, number) -> (1 == number % 2) ?
                result + (number * number) : result;
    }

}
