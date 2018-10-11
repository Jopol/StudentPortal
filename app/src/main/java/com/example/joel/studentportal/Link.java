package com.example.joel.studentportal;


import java.io.Serializable;

public class Link implements Serializable {
    private String url, title;

    public Link(String url, String title) {

        this.url = url;
        this.title = title;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
