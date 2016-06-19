package com.asb.demo.lambdas.recursion;

import com.asb.demo.lambdas.strategies.DnCLambdas;

/**
 * DecreaseAndConquer Interface.
 * Created by arjun on 18/06/16.
 */
public interface DecreaseAndConquer<T, R> {
    /**
     * Gets the value of decrease and conquer.
     *
     * @param value   value for result to compute
     * @param lambdas lambdas
     * @return result
     */
    R conquer(T value, DnCLambdas<T, R> lambdas);
}
