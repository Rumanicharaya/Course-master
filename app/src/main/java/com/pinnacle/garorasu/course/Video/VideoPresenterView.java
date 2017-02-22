package com.pinnacle.garorasu.course.Video;

/**
 * Created by Ideal on 2/18/2017.
 */

public interface VideoPresenterView {
    void requestVideo();
    void onSuccess();
    void onFailure();
    void sendVideoToAdapter(Video video);
    void onVideoSelect(Video video);
    void networkUnavailable();

}
