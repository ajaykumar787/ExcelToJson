package com.grokonez.convertexcel2json;

import java.util.List;

public class Customer {
  /*private String id;
  private String name;
  private String address;
  private int age;*/

  private Info info;
  private List<Tests> tests;

  public Customer() {
  }
 
  /*public Customer(String id, String name, String address, int age) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }*/

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  public List<Tests> getTests() {
    return tests;
  }

  public void setTests(List<Tests> tests) {
    this.tests = tests;
  }
 
  /*@Override
  public String toString() {
    return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + "]";
  }*/
 
}