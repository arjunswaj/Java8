package com.asb.demo.client.impl;

import com.asb.demo.client.StudentClient;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by arjun on 29/01/16.
 */
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class FastStudentClientBenchMark {

  private StudentClient studentClient;

  @Setup
  public void prepare() {
    studentClient = new FastStudentClient(1, true);
  }

  @Benchmark
  public void testParallel() {
    studentClient.setParallel(true);
    studentClient.getStudents().forEach(student -> System.out.println(student.getName()));
  }

  @Benchmark
  public void testSerial() {
    studentClient.setParallel(false);
    studentClient.getStudents().forEach(student -> System.out.println(student.getName()));
  }
}
