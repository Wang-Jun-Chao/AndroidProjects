package com.itheima.domain;

/**
 * Author: 王俊超
 * Date: 2015-10-05
 * Time: 14:57
 * Declaration: All Rights Reserved !!!
 */
public class Person {
    private String id;
    private String name;
    private String phone;
    private String salary;

    public Person() {
    }

    public Person(String id, String name, String phone, String salary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ", " + phone + ", " + salary;
    }
}


