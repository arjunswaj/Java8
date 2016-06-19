package com.asb.demo.lambdas.strategies.impl.strings;

import com.asb.demo.lambdas.strategies.DnCLambdas;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Special Character Counter.
 * Created by arjun on 19/06/16.
 */
public class SpecialCharacterCounter implements DnCLambdas<String, Integer> {
    private static final String SPECIAL_CHARACTERS = "/*!@#$%^&*()" +
            "\"{}_[]|\\?/<>,.~";

    @Override
    public Predicate<String> predicate() {
        return s -> s.length() == 0;
    }

    @Override
    public Function<String, Integer> baseCase() {
        return s -> 0;
    }

    @Override
    public Function<String, String> decreaseOperation() {
        return s -> s.substring(1);
    }

    @Override
    public BiFunction<Integer, String, Integer> recursiveCase() {
        return (result, s) -> SPECIAL_CHARACTERS.contains(
                s.substring(0, 1)) ? result + 1 : result;
    }
}
