package com.asb.demo.lambdas.recursion;

/**
 * Recursion Interface.
 * Created by arjun on 18/06/16.
 */
public interface Recursion<T, R, U> {
    /**
     * Gets the value of number recursion
     *
     * @param value          value for result to compute
     * @param recursionTypes recursion type
     * @return result
     */
    R recursion(T value, U recursionTypes);
}
