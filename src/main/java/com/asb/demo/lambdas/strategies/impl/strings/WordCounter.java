package com.asb.demo.lambdas.strategies.impl.strings;

import com.asb.demo.lambdas.strategies.DnCLambdas;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Word Counter.
 * Created by arjun on 19/06/16.
 */
public class WordCounter implements DnCLambdas<String, Integer> {
    @Override
    public Predicate<String> predicate() {
        return s -> s.indexOf(" ") == -1;
    }

    @Override
    public Function<String, Integer> baseCase() {
        return s -> 1;
    }

    @Override
    public Function<String, String> valueOperator() {
        return s -> s.substring(s.indexOf(" ") + 1);
    }

    @Override
    public BiFunction<Integer, String, Integer> recursiveCase() {
        return (result, s) -> result + 1;
    }
}
