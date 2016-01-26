package com.asb.demo.client.impl;

import com.asb.demo.datasource.StudentProducer;
import com.asb.demo.datasource.impl.StudentProducerImpl;
import com.asb.demo.eo.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by arjun on 23/01/16.
 */
public class SlowStudentClient implements com.asb.demo.client.StudentClient {
  private StudentProducer studentProducer = StudentProducerImpl.getInstance();
  private List<String> names = Arrays.asList("Jayanth", "Gunjan", "Gaurav", "Aniket");
  private Random random = new Random();
  private int instance;

  public SlowStudentClient(int instance) {
    this.instance = instance;
  }

  @Override
  public List<Student> getStudents() {
    return names.parallelStream()
        .map(name -> getStudentFromProducer(name))
        .collect(Collectors.toList());
  }

  private Student getStudentFromProducer(String name) {
    System.out.println(instance + ": Slow Producer: " + name + " in " + Thread.currentThread().getName());
    Student student;
    try {
      Thread.sleep(100 + random.nextInt(200));
      student = studentProducer.produce(name);
    } catch (Exception ignored) {
      student = new Student("", 0);
    }
    return student;
  }
}
