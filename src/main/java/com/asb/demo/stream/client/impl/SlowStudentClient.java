package com.asb.demo.stream.client.impl;

import com.asb.demo.stream.datasource.StudentProducer;
import com.asb.demo.stream.datasource.impl.StudentProducerImpl;
import com.asb.demo.stream.eo.Student;
import com.asb.demo.stream.client.StudentClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by arjun on 23/01/16.
 */
public class SlowStudentClient implements StudentClient {
  private StudentProducer studentProducer = StudentProducerImpl.getInstance();
  private List<String> names = Arrays.asList("Jayanth", "Gunjan", "Gaurav", "Aniket");
  private int instance;
  private boolean parallel;

  public SlowStudentClient(int instance, boolean parallel) {
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
    Student student;
    try {
      Thread.sleep(300);
      student = studentProducer.produce(name);
    } catch (Exception ignored) {
      student = new Student("", 0);
    }
    return student;
  }
}
