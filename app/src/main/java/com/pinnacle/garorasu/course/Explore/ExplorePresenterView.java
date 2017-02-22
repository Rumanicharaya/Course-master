package com.pinnacle.garorasu.course.Explore;

/**
 * Created by garorasu on 16/2/17.
 */

public interface ExplorePresenterView {
    void sendDataToAdapter(Subject subject);
    void requestSubject();
    void onSuccess();
    void onFailure();
    void onSubjectSelect(Subject subject);
}
