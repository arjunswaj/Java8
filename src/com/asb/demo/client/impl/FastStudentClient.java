package com.asb.demo.client.impl;

import com.asb.demo.client.StudentClient;
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
public class FastStudentClient implements StudentClient {
  private int instance;
  private StudentProducer studentProducer = StudentProducerImpl.getInstance();
  private List<String> names = Arrays.asList("Arjun", "Nitesh", "Anusha", "Tuli", "Anubhav");
  private Random random = new Random();

  public FastStudentClient(int instance) {
    this.instance = instance;
  }

  @Override
  public List<Student> getStudents() {
    return names.parallelStream()
        .map(name -> getStudentFromProducer(name))
        .collect(Collectors.toList());
  }

  private Student getStudentFromProducer(String name) {
    System.out.println(instance + ": Fast Producer: " + name + " in " + Thread.currentThread().getName());
    Student student;
    try {
      Thread.sleep(random.nextInt(300));
      student = studentProducer.produce(name);
    } catch (InterruptedException ignored) {
      student = new Student("", 0);
    }
    return student;
  }
}
