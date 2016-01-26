package com.asb.demo.eo;

/**
 * Created by arjun on 23/01/16.
 */
public class Student {
  private String name;
  private int total;

  public Student(String name, int total) {
    this.name = name;
    this.total = total;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
