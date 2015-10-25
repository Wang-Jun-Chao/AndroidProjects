package com.itheima.getsms.domain;

/**
 * Author: 王俊超
 * Date: 2015-10-25
 * Time: 15:04
 * Declaration: All Rights Reserved !!!
 */
public class Message {
    private String body;
    private String type;
    private String address;
    private long date;

    public Message(String body, String type, String address, long date) {
        this.body = body;
        this.type = type;
        this.address = address;
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
