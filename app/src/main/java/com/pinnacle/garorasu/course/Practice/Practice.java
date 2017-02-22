package com.pinnacle.garorasu.course.Practice;

/**
 * Created by Ideal on 2/18/2017.
 */

public class Practice {
    private String serialno;
    private String title;
    private String practiceDescription;
    private String id;
    private String url;

    public Practice(String serialno, String title, String practiceDescription) {
        this.serialno = serialno;
        this.title = title;
        this.practiceDescription = practiceDescription;

    }

    public String getSerialno() {
        return serialno;
    }

    public String getTitle() {
        return title;
    }

    public String getpracticeDescription() {
        return practiceDescription;
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

    public void setpracticeDescription(String practiceDescription) {
        this.practiceDescription = practiceDescription;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
