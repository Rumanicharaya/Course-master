package com.pinnacle.garorasu.course.Lesson;

/**
 * Created by Ideal on 2/18/2017.
 */

public interface LessonPresenterView {
    void onLessonSelect(Lesson lesson);
    void requestLesson();
    void onSuccess();
    void onFailure();
    void  sendLessonToAdapter(Lesson lesson);
    void networkUnavailable();
}
