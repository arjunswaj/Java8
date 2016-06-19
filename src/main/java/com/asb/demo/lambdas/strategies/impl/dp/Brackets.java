package com.asb.demo.lambdas.strategies.impl.dp;

import com.asb.demo.lambdas.strategies.DnCLambdas;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Types of valid Brackets.
 * Created by arjun on 19/06/16.
 */
public class Brackets implements DnCLambdas<Integer, Set<String>> {
    @Override
    public Predicate<Integer> predicate() {
        return integer -> integer == 1;
    }

    @Override
    public Function<Integer, Set<String>> baseCase() {
        return integer -> Collections.singleton("()");
    }

    @Override
    public Function<Integer, Integer> valueOperator() {
        return integer -> integer - 1;
    }

    @Override
    public BiFunction<Set<String>, Integer, Set<String>> recursiveCase() {
        return (brackets, integer) ->
                brackets.stream()
                        .flatMap(s -> {
                            Set<String> set = new HashSet<>(3);
                            set.add("(" + s + ")");
                            set.add("()" + s);
                            set.add(s + "()");
                            return set.stream();
                        })
                        .collect(Collectors.toSet());
    }
}
