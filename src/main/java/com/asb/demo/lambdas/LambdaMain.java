package com.asb.demo.lambdas;

import com.asb.demo.lambdas.factory.impl.NumberRecursionFactory;
import com.asb.demo.lambdas.recursion.NumberRecursionTypes;
import com.asb.demo.lambdas.recursion.Recursion;
import com.asb.demo.lambdas.recursion.impl.RecursionImpl;

import java.util.Arrays;

/**
 * Lambda Driver.
 * Created by arjun on 18/06/16.
 */
public class LambdaMain {

    public static void main(String[] args) {
        Recursion<Integer, Integer, NumberRecursionTypes> numberRecursion =
                new RecursionImpl<>(
                        new NumberRecursionFactory());
        Arrays.asList(NumberRecursionTypes.values())
                .forEach(recursionTypes ->
                        System.out.println(
                                numberRecursion.recursion(5, recursionTypes)));
    }
}
