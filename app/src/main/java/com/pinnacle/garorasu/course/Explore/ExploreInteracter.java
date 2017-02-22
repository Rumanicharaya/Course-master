package com.pinnacle.garorasu.course.Explore;

import android.os.AsyncTask;
import com.pinnacle.garorasu.course.SujbectInfo;

import java.util.ArrayList;

/**
 * Created by garorasu on 16/2/17.
 */

public class ExploreInteracter implements ExploreInteracterView {
    private final ExplorePresenter presenter;
    public ExploreInteracter(ExplorePresenter explorePresenter){
        this.presenter = explorePresenter;
    }

    @Override
    public void requestData() {
        ArrayList<Subject> allSubjects = SujbectInfo.getAllSubjects();
        for(Subject subject:allSubjects){
            presenter.sendDataToAdapter(subject);
        }
        presenter.onSuccess();

    }
    private class loadDataInBackground extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... params) {

            /*
            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("blog");
            myRef.keepSynced(true);
            final ValueEventListener postListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Get Post object and use the values to update the UI
                    for(DataSnapshot ds:dataSnapshot.getChildren()) {
                        Feed feed = ds.getValue(Feed.class);
                        presenter.sendDatatoAdapter(feed);
                        System.out.println("Post data fetched from firebase is : " + feed.getHeader());
                        presenter.onSuccess();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Getting Post failed, log a message
                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                    presenter.onFailure();
                    // ...
                }
            };
            myRef.addListenerForSingleValueEvent(postListener);
            return null;
            */
            return null;
        }
    }
}
