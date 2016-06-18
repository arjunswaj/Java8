package com.asb.demo.stream.client;

import com.asb.demo.stream.eo.Student;

import java.util.List;

/**
 * Created by arjun on 23/01/16.
 */
public interface StudentClient {
  List<Student> getStudents();
  void setParallel(boolean parallel);
}
