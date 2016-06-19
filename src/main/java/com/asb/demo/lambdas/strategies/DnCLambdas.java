package com.asb.demo.lambdas.strategies;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Decrease and Conquer.
 * Created by arjun on 18/06/16.
 */
public interface DnCLambdas<T, R> {

    /**
     * Predicate of the conquer.
     *
     * @return predicate
     */
    Predicate<T> predicate();

    /**
     * Base case of the conquer.
     *
     * @return base case
     */
    Function<T, R> baseCase();

    /**
     * Decrease operation of the conquer.
     *
     * @return decrease operation lambda
     */
    Function<T, T> decreaseOperation();

    /**
     * Recursive case of the conquer.
     *
     * @return value operator
     */
    BiFunction<R, T, R> recursiveCase();
}
