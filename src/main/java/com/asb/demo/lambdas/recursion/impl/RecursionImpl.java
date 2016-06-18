package com.asb.demo.lambdas.recursion.impl;

import com.asb.demo.lambdas.factory.RecursionFactory;
import com.asb.demo.lambdas.factory.impl.NumberRecursionFactory;
import com.asb.demo.lambdas.recursion.NumberRecursionTypes;
import com.asb.demo.lambdas.recursion.Recursion;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Recursion Implementation.
 * Created by arjun on 18/06/16.
 */
public class RecursionImpl<T, R, U> implements Recursion<T, R, U> {

    private RecursionFactory<T, R, U> recursionFactory;

    public RecursionImpl(
            RecursionFactory<T, R, U> recursionFactory) {
        this.recursionFactory = recursionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public R recursion(T value, U recursionTypes) {
        Predicate<T> predicate =
                recursionFactory.predicate(recursionTypes);
        Function<T, R> baseCase =
                recursionFactory.baseCase(recursionTypes);
        Function<T, T> valueOperator =
                recursionFactory.valueOperator(recursionTypes);
        BiFunction<R, T, R> recursiveCase =
                recursionFactory.recursiveCase(recursionTypes);
        return this.recursion(predicate, baseCase, valueOperator,
                recursiveCase, value);
    }

    private R recursion(Predicate<T> predicate,
                        Function<T, R> baseCase,
                        Function<T, T> valueOperator,
                        BiFunction<R, T, R> recursiveCase, T value) {
        if (predicate.test(value)) {
            return baseCase.apply(value);
        }
        return recursiveCase.apply(
                this.recursion(predicate, baseCase, valueOperator,
                        recursiveCase, valueOperator.apply(value)),
                value);
    }

    public void setRecursionFactory(
            RecursionFactory<T, R, U> recursionFactory) {
        this.recursionFactory = recursionFactory;
    }
}
