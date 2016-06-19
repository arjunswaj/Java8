package com.asb.demo.lambdas.factory.impl;

import com.asb.demo.lambdas.factory.DnCLambdaFactory;
import com.asb.demo.lambdas.strategies.DnCLambdas;
import com.asb.demo.lambdas.strategies.constants.NumberDnCTypes;
import com.asb.demo.lambdas.strategies.impl.numbers.*;

/**
 * Number Lambda Factory.
 * Created by arjun on 19/06/16.
 */
public class NumberLambdaFactory
        implements DnCLambdaFactory<Integer, Integer, NumberDnCTypes> {
    @Override
    public DnCLambdas<Integer, Integer> lambda(NumberDnCTypes type) {
        DnCLambdas<Integer, Integer> lambdas = null;
        switch (type) {
            // TODO: Use Singletons and injection
            case FACTORIAL:
                lambdas = new Factorial();
                break;
            case SUMMATION:
                lambdas = new Summation();
                break;
            case SUM_OF_SQUARES:
                lambdas = new SumOfSquares();
                break;
            case SUM_OF_SQUARES_OF_ODD_NUMBERS:
                lambdas = new SumOfSquaresOfOddNumbers();
                break;
            case SUM_OF_SQUARES_OF_EVEN_NUMBERS:
                lambdas = new SumOfSquaresOfOddNumbers();
                break;
        }
        return lambdas;
    }
}
