package com.itheima.pullparser.domain;

/**
 * Author: 王俊超
 * Date: 2015-10-04
 * Time: 19:18
 * Declaration: All Rights Reserved !!!
 */
public class City {
    private String name;
    private String temp;
    private String pm;

    public City() {

    }

    public City(String name, String temp, String pm) {
        this.name = name;
        this.temp = temp;
        this.pm = pm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", temp='" + temp + '\'' +
                ", pm='" + pm + '\'' +
                '}';
    }
}
