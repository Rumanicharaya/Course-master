package com.pinnacle.garorasu.course;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pinnacle.garorasu.course.Lesson.Lesson;
import com.pinnacle.garorasu.course.Practice.Practice;
import com.pinnacle.garorasu.course.Video.Video;

public class DetailActivity extends AppCompatActivity implements DetailActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i =getIntent() ;
        //subject=i.getStringExtra("subject");
        setContentView(R.layout.activity_detail);
    }

    @Override
    public void lessonSelected(Lesson lesson) {

    }

    @Override
    public void practiceSelected(Practice practice) {

    }

    @Override
    public void videoSelected(Video video) {

    }
}
