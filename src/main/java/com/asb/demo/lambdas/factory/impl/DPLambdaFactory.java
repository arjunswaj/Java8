package com.asb.demo.lambdas.factory.impl;

import com.asb.demo.lambdas.factory.DnCLambdaFactory;
import com.asb.demo.lambdas.strategies.DnCLambdas;
import com.asb.demo.lambdas.strategies.constants.DPTypes;
import com.asb.demo.lambdas.strategies.impl.dp.Brackets;

import java.util.Set;

/**
 * DP Lambda Factory for Decrease and Conquer.
 * Created by arjun on 19/06/16.
 */
public class DPLambdaFactory
        implements DnCLambdaFactory<Integer, Set<String>, DPTypes> {
    @Override
    public DnCLambdas<Integer, Set<String>> lambda(DPTypes type) {
        DnCLambdas<Integer, Set<String>> lambdas = null;
        switch (type) {

            case BRACKETS:
                lambdas = new Brackets();
                break;

        }
        return lambdas;
    }
}
