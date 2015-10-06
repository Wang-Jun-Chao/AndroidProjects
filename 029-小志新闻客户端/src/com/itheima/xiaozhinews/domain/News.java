package com.itheima.xiaozhinews.domain;

/**
 * Author: 王俊超
 * Date: 2015-10-06
 * Time: 16:50
 * Declaration: All Rights Reserved !!!
 */
public class News {
    private String title;
    private String detail;
    private String comment;
    private String image;

    public News() {
    }

    public News(String title, String detail, String comment, String image) {
        this.title = title;
        this.detail = detail;
        this.comment = comment;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", comment='" + comment + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
