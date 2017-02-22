package com.pinnacle.garorasu.course.Video;

import com.pinnacle.garorasu.course.Lesson.Lesson;

/**
 * Created by Ideal on 2/18/2017.
 */

public class VideoPresenter implements VideoPresenterView{
    private final VideoAdapterView adapter;
    private final VideoView view;
    private final VideoInteracterView interactor;

    public VideoPresenter(VideoAdapterView videoAdapterView, VideoView videoView) {
         this.adapter=videoAdapterView;
         this.view=videoView;
        this.interactor = new VideoInteracter(this);


    }

    @Override
    public void onVideoSelect(Video video) {
        if(view !=null){
            view.onVideoClick(video);
        }
    }

    @Override
    public void requestVideo() {
        if(view !=null){
            view.showProgress();
        }
        interactor.requestVideo();
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
    public void sendVideoToAdapter(Video video) {
        adapter.addVideo(video);
    }

    @Override
    public void networkUnavailable() {

    }
}
