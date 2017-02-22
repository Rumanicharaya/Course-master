package com.pinnacle.garorasu.course.Practice;

/**
 * Created by Ideal on 2/18/2017.
 */

public class PracticePresenter implements PracticePresenterView {
    private final PracticeAdapterView adapter;
    private final PracticeView view;
    private final PracticeInteracter interactor;

    public PracticePresenter(PracticeAdapter practiceAdapter, PracticeView practiceView) {
        this.adapter = practiceAdapter;
        this.view = practiceView;
        this.interactor = new PracticeInteracter(this);
    }

    @Override
    public void onPracticeSelect(Practice practice) {
        if (view != null) {
            view.onPracticeClick(practice);

        }


    }

    @Override
    public void requestPractice() {
        if(view !=null) {
            view.showProgress();
        }
        interactor.requestPractice();

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
    public void sendPracticeToAdapter(Practice practice) {
        adapter.addPractice(practice);
    }

    @Override
    public void networkUnavailable() {

    }
}