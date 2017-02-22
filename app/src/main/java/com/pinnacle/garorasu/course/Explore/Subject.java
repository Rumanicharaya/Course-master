package com.pinnacle.garorasu.course.Explore;

import android.graphics.Color;

import java.io.Serializable;


public class Subject implements Serializable {
    private String title;
    private String imgUrl;
    private String brief;
    private String color;

    public Subject(String title,String imgUrl,String brief,String color){
        this.title = title;
        this.imgUrl = imgUrl;
        this.brief = brief;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public String getBrief() {
        return brief;
    }

    public String getImgUrl() {
        return imgUrl;
    }
    public String getColor() {return  color;}
}
