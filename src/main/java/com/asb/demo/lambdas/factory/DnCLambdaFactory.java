package com.asb.demo.lambdas.factory;

import com.asb.demo.lambdas.strategies.DnCLambdas;

/**
 * Decrease and Conquer Lambda Factory interface.
 * Created by arjun on 19/06/16.
 */
public interface DnCLambdaFactory<T, R, U> {
    /**
     * Gets the lambdas for Decrease and Conquer.
     *
     * @param type type of the problem
     * @return lambda instance
     */
    DnCLambdas<T, R> lambda(U type);
}
