package com.asb.demo.lambdas.factory.impl;

import com.asb.demo.lambdas.factory.DnCLambdaFactory;
import com.asb.demo.lambdas.strategies.DnCLambdas;
import com.asb.demo.lambdas.strategies.constants.StringDnCTypes;
import com.asb.demo.lambdas.strategies.impl.strings.SpecialCharacterCounter;
import com.asb.demo.lambdas.strategies.impl.strings.WordCounter;

/**
 * String Lambda Factory.
 * Created by arjun on 19/06/16.
 */
public class StringLambdaFactory implements DnCLambdaFactory<String, Integer, StringDnCTypes>{

    @Override
    public DnCLambdas<String, Integer> lambda(StringDnCTypes type) {
        DnCLambdas<String, Integer> lambda = null;
        switch (type) {

            case WORD_COUNT:
                lambda = new WordCounter();
                break;
            case SPECIAL_CHARACTERS_COUNTER:
                lambda = new SpecialCharacterCounter();
                break;
        }
        return lambda;
    }
}
