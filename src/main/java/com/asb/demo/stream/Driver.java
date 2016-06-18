package com.asb.demo.stream;

import com.asb.demo.stream.collector.StudentCollector;

import java.util.stream.IntStream;

/**
 * Created by arjun on 23/01/16.
 */
public class Driver {
  public static void main(String... args) {
    IntStream.range(1, 10)
        .forEach(value -> new Thread(new StudentCollector(value)).start());
  }
}
