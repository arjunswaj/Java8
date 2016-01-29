package com.asb.demo.datasource;

import com.asb.demo.eo.Student;

/**
 * Created by arjun on 23/01/16.
 */
public interface StudentProducer {
  Student produce(String key);
}
