package com.asb.demo.stream.client.impl;

import com.asb.demo.stream.client.StudentClient;
import com.asb.demo.stream.eo.Student;
import org.openjdk.jmh.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by arjun on 29/01/16.
 */
@BenchmarkMode(Mode.All)
@OutputTimeUnit(TimeUnit.SECONDS)
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
    List<Student> students = studentClient.getStudents();
    System.out.println("Size: " + students.size());
  }

  @Benchmark
  public void testSerial() {
    studentClient.setParallel(false);
    List<Student> students = studentClient.getStudents();
    System.out.println("Size: " + students.size());
  }
}
