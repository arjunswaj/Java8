package com.asb.demo.lambdas.recursion.impl;

import com.asb.demo.lambdas.recursion.DecreaseAndConquer;
import com.asb.demo.lambdas.strategies.DnCLambdas;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Decrease And Conquer Implementation.
 * Created by arjun on 18/06/16.
 */
public class DecreaseAndConquerImpl<T, R> implements DecreaseAndConquer<T, R> {

    /**
     * {@inheritDoc}
     */
    @Override
    public R conquer(T value, DnCLambdas<T, R> lambdas) {
        return this.conquer(lambdas.predicate(),
                lambdas.baseCase(),
                lambdas.decreaseOperation(),
                lambdas.recursiveCase(),
                value);
    }

    private R conquer(Predicate<T> predicate,
                      Function<T, R> baseCase,
                      Function<T, T> decreaseOperation,
                      BiFunction<R, T, R> recursiveCase, T value) {
        if (predicate.test(value)) {
            return baseCase.apply(value);
        }
        return recursiveCase.apply(
                this.conquer(predicate, baseCase, decreaseOperation,
                        recursiveCase, decreaseOperation.apply(value)),
                value);
    }
}
