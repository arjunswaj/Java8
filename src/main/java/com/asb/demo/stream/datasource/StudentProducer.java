package com.asb.demo.stream.datasource;

import com.asb.demo.stream.eo.Student;

/**
 * Created by arjun on 23/01/16.
 */
public interface StudentProducer {
  Student produce(String key);
}
