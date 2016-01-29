package com.asb.demo.client.impl;

import com.asb.demo.client.StudentClient;
import com.asb.demo.datasource.StudentProducer;
import com.asb.demo.datasource.impl.StudentProducerImpl;
import com.asb.demo.eo.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by arjun on 23/01/16.
 */
public class FastStudentClient implements StudentClient {
  private int instance;
  private boolean parallel;
  private StudentProducer studentProducer = StudentProducerImpl.getInstance();
  private List<String> names = Arrays.asList("Arjun", "Nitesh", "Anusha", "Tuli", "Anubhav");

  public FastStudentClient(int instance, boolean parallel) {
    this.instance = instance;
    this.parallel = parallel;
  }

  @Override
  public void setParallel(boolean parallel) {
    this.parallel = parallel;
  }

  @Override
  public List<Student> getStudents() {
    return getStudentStream()
        .map(name -> getStudentFromProducer(name))
        .collect(Collectors.toList());
  }

  private Stream<String> getStudentStream() {
    Stream<String> stream;
    if (parallel) {
      stream = names.parallelStream();
    } else {
      stream = names.stream();
    }
    return stream;
  }

  private Student getStudentFromProducer(String name) {
    System.out.println(instance + ": Fast Producer: " + name + " in " + Thread.currentThread().getName());
    Student student;
    try {
      Thread.sleep(100);
      student = studentProducer.produce(name);
    } catch (InterruptedException ignored) {
      student = new Student("", 0);
    }
    return student;
  }
}
