package com.pinnacle.garorasu.course.Lesson;

import com.pinnacle.garorasu.course.Explore.Subject;
import com.pinnacle.garorasu.course.SujbectInfo;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/18/2017.
 */

public class LessonInteracter implements LessonInteracterView {
    private final LessonPresenter lessonPresenter;
    public LessonInteracter(LessonPresenter lessonPresenter){
        this.lessonPresenter = lessonPresenter;
    }

    @Override
    public void requestLesson() {
        ArrayList<Lesson> allLessons = LessonInfo.getAllLesson();
        for(Lesson lesson:allLessons){
            lessonPresenter.sendLessonToAdapter(lesson);
        }
        lessonPresenter.onSuccess();
    }
}
