package com.pinnacle.garorasu.course.Lesson;

/**
 * Created by Ideal on 2/18/2017.
 */
public class Lesson {
    private String title;
    private String lessonDescription;
    private String id;
    private String image;
    private String url;
    private String serialno;

    public Lesson(String title, String image, String lessonDescription, String serialno) {
        this.title = title;
        this.image=image;
        this.lessonDescription = lessonDescription;
        this.serialno=serialno;
    }

    public String getSerialno() {return serialno; }

    public String getTitle() {
        return title;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String setSerialno() {return serialno; }


}
