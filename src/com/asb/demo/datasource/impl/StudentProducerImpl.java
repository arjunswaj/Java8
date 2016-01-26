package com.asb.demo.datasource.impl;

import com.asb.demo.datasource.StudentProducer;
import com.asb.demo.eo.Student;

import java.util.Random;

/**
 * Created by arjun on 23/01/16.
 */
public class StudentProducerImpl implements StudentProducer {
  private static volatile StudentProducer instance;
  private Random random = new Random();

  private StudentProducerImpl() {
  }

  public static StudentProducer getInstance() {
    if (null == instance) {
      synchronized (StudentProducerImpl.class) {
        if (null == instance) {
          instance = new StudentProducerImpl();
        }
      }
    }
    return instance;
  }

  @Override
  public Student produce(String key) {
    try {
      Thread.sleep(random.nextInt(1000));
    } catch (InterruptedException ignore) {
    }
    return new Student(key, key.length() * random.nextInt(12345) % 600);
  }
}
