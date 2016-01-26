package com.asb.demo.collector;

import com.asb.demo.client.impl.FastStudentClient;
import com.asb.demo.client.impl.SlowStudentClient;
import com.asb.demo.eo.Student;

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
        Arrays.asList(new FastStudentClient(instance),
            new SlowStudentClient(instance))
            .parallelStream()
            .flatMap(studentClient -> studentClient
                .getStudents()
                .stream())
            .collect(Collectors.toMap(s -> s.getName(), s -> s,
                (s1, s2) -> s1.getTotal() > s2.getTotal() ? s1 : s2));

    students.entrySet()
        .stream()
        .forEach(entry -> System.out.println(instance + ": " + entry.getKey() + ":"
            + entry.getValue().getTotal()));
  }

}
