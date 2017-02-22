package com.pinnacle.garorasu.course.Practice;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/18/2017.
 */

public class PracticeInteracter implements PracticeInteracterView{
    private final PracticePresenter practicePresenter;

    public PracticeInteracter(PracticePresenter practicePresenter) {
        this.practicePresenter = practicePresenter;
    }

    public void requestPractice() {
        ArrayList<Practice> allPractice = PracticeInfo.getAllLesson();
        for(Practice practice:allPractice){
            practicePresenter.sendPracticeToAdapter(practice);
        }
       practicePresenter.onSuccess();
    }

}
