package com.itheima.xmlserializer.domain;

/**
 * Author: 王俊超
 * Date: 2015-10-04
 * Time: 08:51
 * Declaration: All Rights Reserved !!!
 */
public class Message {
    private String body;
    private String date;
    private String address;
    private String type;

    public Message(String body, String date, String address, String type) {
        this.body = body;
        this.date = date;
        this.address = address;
        this.type = type;
    }

    public Message() {
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
