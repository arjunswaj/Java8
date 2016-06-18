package com.asb.demo.lambdas.factory;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Recursion Factory.
 * Created by arjun on 18/06/16.
 */
public interface RecursionFactory<T, R, U> {

    /**
     * Predicate of the recursion.
     *
     * @param u enum
     * @return predicate
     */
    Predicate<T> predicate(U u);

    /**
     * Base case of the recursion.
     *
     * @param u enum
     * @return base case
     */
    Function<T, R> baseCase(U u);

    /**
     * Value operator of the recursion.
     *
     * @param u enum
     * @return value operator
     */
    Function<T, T> valueOperator(U u);

    /**
     * Recursive case of the recursion.
     *
     * @param u enum
     * @return value operator
     */
    BiFunction<R, T, R> recursiveCase(U u);
}
