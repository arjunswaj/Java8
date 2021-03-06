package com.asb.demo.lambdas.strategies.impl.numbers;

import java.util.function.BiFunction;

/**
 * Factorial of a number.
 * Created by arjun on 19/06/16.
 */
public class Factorial extends AbstractNumberLambdas {

    @Override
    public BiFunction<Integer, Integer, Integer> recursiveCase() {
        return (result, number) -> result * number;
    }

}
