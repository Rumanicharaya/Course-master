package com.pinnacle.garorasu.course.Explore;

/**
 * Created by garorasu on 16/2/17.
 */

public class ExplorePresenter implements ExplorePresenterView {
    private final ExploreAdapterView adapter;
    private final ExploreView view;
    private final ExploreInteracterView interactor;

    public ExplorePresenter(ExploreAdapterView exploreAdaterView,ExploreView exploreView){
        this.adapter = exploreAdaterView;
        this.view = exploreView;
        this.interactor = new ExploreInteracter(this);
    }

    @Override
    public void sendDataToAdapter(Subject subject) {
        adapter.addSubject(subject);
    }

    @Override
    public void requestSubject() {
        if(view !=null){
            view.showProgress();
        }
        interactor.requestData();
    }

    @Override
    public void onSubjectSelect(Subject subject) {
        if(view !=null){
            view.onSubjectClick(subject);
        }
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

}
