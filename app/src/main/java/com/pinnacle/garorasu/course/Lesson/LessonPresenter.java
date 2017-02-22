package com.pinnacle.garorasu.course.Lesson;

/**
 * Created by Ideal on 2/18/2017.
 */

public class LessonPresenter implements LessonPresenterView {
    private final LessonAdapterView adapter;
    private final LessonView view;
    private final LessonInteracter interactor;

    public LessonPresenter(LessonAdapterView lessonAdapterView,LessonView lessonView){
        this.adapter = lessonAdapterView;
        this.view = lessonView;
        this.interactor = new LessonInteracter(this);
    }

    @Override
    public void onLessonSelect(Lesson lesson) {
        if(view !=null){
            view.onLessonClick(lesson);
        }
    }

    @Override
    public void requestLesson() {
        if(view !=null){
            view.showProgress();
        }
        interactor.requestLesson();
    }

    @Override
    public void onSuccess() {
        if(view !=null){
            view.hideProgress();
        }
    }

    @Override
    public void onFailure() {
        if(view !=null){
            view.showProgress();
        }
    }

    @Override
    public void sendLessonToAdapter(Lesson lesson) {
        adapter.addLesson(lesson);
    }

    @Override
    public void networkUnavailable() {

    }
}
