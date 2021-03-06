package com.asb.demo.stream.collector;

import com.asb.demo.stream.client.impl.FastStudentClient;
import com.asb.demo.stream.client.impl.SlowStudentClient;
import com.asb.demo.stream.eo.Student;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by arjun on 23/01/16.
 */
public class StudentCollector implements Runnable {
  private int instance;

  public StudentCollector(int instance) {
    this.instance = instance;
  }

  @Override
  public void run() {

    Map<String, Student> students =
        Arrays.asList(new FastStudentClient(instance, true),
            new SlowStudentClient(instance, true))
            .parallelStream()
            .flatMap(studentClient -> studentClient
                .getStudents()
                .stream())
            .collect(Collectors.toMap(s -> s.getName(), s -> s));

    System.out.println(instance + ":" + students.size());
  }

}
