package com.pinnacle.garorasu.course;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.pinnacle.garorasu.course.Explore.Subject;
import com.pinnacle.garorasu.course.Lesson.Lesson;
import com.pinnacle.garorasu.course.Lesson.LessonListener;
import com.pinnacle.garorasu.course.Lesson.LessonView;
import com.pinnacle.garorasu.course.Practice.Practice;
import com.pinnacle.garorasu.course.Practice.PracticeListener;
import com.pinnacle.garorasu.course.Video.Video;
import com.pinnacle.garorasu.course.Video.VideoListener;

public class SubjectActivity extends AppCompatActivity implements LessonListener,PracticeListener,VideoListener {
    private Subject subjectObject;
    String subject;
    Toolbar toolbar;
    String color;
    ViewPager subjectViewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        Intent i =getIntent() ;
        subjectObject = (Subject) i.getSerializableExtra("subjectObject");
        subject=subjectObject.getTitle();
        color =  subjectObject.getColor();
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setBackgroundColor(Color.parseColor(color));


        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Window window=getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.BLACK);

        subjectViewPager=(ViewPager) findViewById(R.id.v1);
        subjectViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),getApplicationContext(),subjectObject));
        tabLayout=(TabLayout) findViewById(R.id.t1);
        tabLayout.setupWithViewPager(subjectViewPager);
        tabLayout.setBackgroundColor(Color.parseColor(color));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                subjectViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                subjectViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                subjectViewPager.setCurrentItem(tab.getPosition());
            }
        });

    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void lessonSelect(Lesson lesson) {
        Intent intent= new Intent(getApplicationContext(),DetailActivity.class);
        Log.d("SubjectActivity","lesson select"+lesson.getTitle());
        //intent.putExtra("subject", subject.getTitle());
        //intent.putExtra("color", subject.getColor());
        startActivity(intent);

    }

    @Override
    public void practiceSelect(Practice practice) {
        Intent intent= new Intent(getApplicationContext(),DetailActivity.class);
        Log.d("SubjectActivity","practice select"+practice.getTitle());
        //intent.putExtra("subject", subject.getTitle());
        //intent.putExtra("color", subject.getColor());
        startActivity(intent);

    }

    @Override
    public void videoSelect(Video video) {
        Intent intent= new Intent(getApplicationContext(),DetailActivity.class);
        Log.d("SubjectActivity","video select"+video.getTitle());
        //intent.putExtra("subject", subject.getTitle());
        //intent.putExtra("color", subject.getColor());
        startActivity(intent);

    }
}
