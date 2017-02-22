package com.pinnacle.garorasu.course;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.pinnacle.garorasu.course.Explore.Subject;
import com.pinnacle.garorasu.course.Lesson.LessonFragment;
import com.pinnacle.garorasu.course.Practice.PracticeFragment;
import com.pinnacle.garorasu.course.Video.VideoFragment;

/**
 * Created by Ideal on 2/18/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{
    String[] a={"Lesson","Video","Practice"};
    private Subject subject;

    public ViewPagerAdapter(FragmentManager supportFragmentManager, Context applicationContext,Subject subject) {
        super(supportFragmentManager);
        this.subject = subject;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LessonFragment().newInstance(subject);
            case 1:
                return new VideoFragment().newInstance(subject);
            case 2:
                return new PracticeFragment().newInstance(subject);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return a.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return a[position];
    }

}

