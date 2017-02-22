package com.pinnacle.garorasu.course.Practice;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.pinnacle.garorasu.course.Explore.Subject;
import com.pinnacle.garorasu.course.Lesson.LessonListener;
import com.pinnacle.garorasu.course.R;
import com.pinnacle.garorasu.course.SimpleDividerItemDecoration;

/**
 * Created by Ideal on 2/18/2017.
 */

public class PracticeFragment extends Fragment implements PracticeView {

    public PracticeFragment() {
    }

    public static PracticeFragment newInstance(Subject subject) {

        Bundle args = new Bundle();
        PracticeFragment fragment = new PracticeFragment();
        args.putSerializable("subject",subject);
        fragment.setArguments(args);
        return fragment;
    }

    PracticeListener mPracticeListener;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private PracticeAdapter adapter;
    private RecyclerView.LayoutManager l;
    private  PracticeView view;
    private Subject subject;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.practicefragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.practiceRecycler);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_practice_fragment);

        if(getArguments() != null){
            subject = (Subject) getArguments().getSerializable("subject");
        }
        adapter = new PracticeAdapter(this,getContext(),subject.getColor());
        adapter.requstPractice();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));

        return view;
    }

    @Override
    public void onPracticeClick(Practice practice) {
mPracticeListener.practiceSelect(practice);
        }



    @Override
    public void showProgress() {
        /*progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
*/    }

    @Override
    public void hideProgress() {/*
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);*/
    }

        public void onAttach(Context context) {
            super.onAttach(context);
            if (context instanceof PracticeListener) {
                mPracticeListener = (PracticeListener) context;
            } else {
                throw new RuntimeException(context.toString()
                        + " must implement PracticeListener");
            }
    }
}
