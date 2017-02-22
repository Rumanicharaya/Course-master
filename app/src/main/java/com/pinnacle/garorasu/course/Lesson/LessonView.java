package com.pinnacle.garorasu.course.Lesson;

import com.pinnacle.garorasu.course.Explore.Subject;

/**
 * Created by Ideal on 2/18/2017.
 */

public interface LessonView {
    void onLessonClick(Lesson lesson);
    void showProgress();
    void hideProgress();

}
