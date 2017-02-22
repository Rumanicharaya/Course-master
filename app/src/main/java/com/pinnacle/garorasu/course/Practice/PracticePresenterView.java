package com.pinnacle.garorasu.course.Practice;

/**
 * Created by Ideal on 2/18/2017.
 */

public interface PracticePresenterView {
    void onPracticeSelect(Practice practice);
    void requestPractice();
    void onSuccess();
    void onFailure();
    void  sendPracticeToAdapter(Practice practice);
    void networkUnavailable();

}
