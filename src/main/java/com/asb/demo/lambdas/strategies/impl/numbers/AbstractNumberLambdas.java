package com.asb.demo.lambdas.strategies.impl.numbers;

import com.asb.demo.lambdas.strategies.DnCLambdas;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by arjun on 19/06/16.
 */
public abstract class AbstractNumberLambdas
        implements DnCLambdas<Integer, Integer> {
    @Override
    public Predicate<Integer> predicate() {
        return integer -> (integer == 1);
    }

    @Override
    public Function<Integer, Integer> baseCase() {
        return integer -> 1;
    }

    @Override
    public Function<Integer, Integer> decreaseOperation() {
        return integer -> integer - 1;
    }
}
