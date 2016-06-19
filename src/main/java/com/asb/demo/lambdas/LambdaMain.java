package com.asb.demo.lambdas;

import com.asb.demo.lambdas.factory.DnCLambdaFactory;
import com.asb.demo.lambdas.factory.impl.DPLambdaFactory;
import com.asb.demo.lambdas.factory.impl.NumberLambdaFactory;
import com.asb.demo.lambdas.factory.impl.StringLambdaFactory;
import com.asb.demo.lambdas.recursion.DecreaseAndConquer;
import com.asb.demo.lambdas.strategies.constants.DPTypes;
import com.asb.demo.lambdas.strategies.constants.NumberDnCTypes;
import com.asb.demo.lambdas.recursion.impl.DecreaseAndConquerImpl;
import com.asb.demo.lambdas.strategies.constants.StringDnCTypes;

import java.util.Arrays;
import java.util.Set;

/**
 * Lambda Main.
 * Created by arjun on 18/06/16.
 */
public class LambdaMain {

    public static void main(String[] args) {
        DecreaseAndConquer<Integer, Integer> dnc = new
                DecreaseAndConquerImpl<>();
        DnCLambdaFactory<Integer, Integer, NumberDnCTypes>
                numberLambdaFactory = new NumberLambdaFactory();
        Arrays.asList(NumberDnCTypes.values())
                .forEach(recursionTypes ->
                        System.out.println(recursionTypes.name() + ": " +
                                dnc.conquer(5, numberLambdaFactory.lambda(
                                        recursionTypes))));


        DecreaseAndConquer<String, Integer> dncString = new
                DecreaseAndConquerImpl<>();
        DnCLambdaFactory<String, Integer, StringDnCTypes>
                strLambdaFactory = new StringLambdaFactory();

        Arrays.asList(StringDnCTypes.values())
                .forEach(recursionTypes ->
                        System.out.println(recursionTypes.name() + ": " +
                                dncString.conquer("#ello ~ there. FP is great!!!",
                                        strLambdaFactory.lambda(
                                                recursionTypes))));

        DecreaseAndConquer<Integer, Set<String>> dncDp = new
                DecreaseAndConquerImpl<>();
        DnCLambdaFactory<Integer, Set<String>, DPTypes>
                dpLambdaFactory = new DPLambdaFactory();

        Arrays.asList(DPTypes.values())
                .forEach(recursionTypes ->
                        System.out.println(recursionTypes.name() + ": " +
                                dncDp.conquer(3, dpLambdaFactory.lambda(
                                        recursionTypes))));


    }
}
