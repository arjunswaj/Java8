package com.asb.demo.lambdas.strategies.impl.numbers;

import java.util.function.BiFunction;

/**
 * Sum of squares of a number.
 * Created by arjun on 19/06/16.
 */
public class SumOfSquares extends AbstractNumberLambdas {

    @Override
    public BiFunction<Integer, Integer, Integer> recursiveCase() {
        return (result, number) -> result + (number * number);
    }

}
