package com.pinnacle.garorasu.course.Lesson;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.pinnacle.garorasu.course.Explore.Subject;
import com.pinnacle.garorasu.course.R;
import com.pinnacle.garorasu.course.SimpleDividerItemDecoration;

public class LessonFragment extends Fragment implements LessonView {
    private RecyclerView recyclerView;
    private LessonAdapter adapter;
    LessonListener mLessonListener;
    private ProgressBar progressBar;
    private Subject subject;
   // private SubjectActivityView subjectActivityView;


    public LessonFragment() {
        // Required empty public constructor

    }
    public static LessonFragment newInstance(Subject subject) {

        Bundle args = new Bundle();
        LessonFragment fragment = new LessonFragment();
        args.putSerializable("subject",subject);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.lessonfragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.lessonRecycler);
      //  progressBar = (ProgressBar) view.findViewById(R.id.progress_lesson_fragment);
        if(getArguments() != null){
            subject = (Subject) getArguments().getSerializable("subject");
        }
        adapter = new LessonAdapter(this,getContext(),subject.getColor());
        adapter.requstLesson();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));


        return view;
    }


    @Override
    public void onLessonClick(Lesson lesson) {
    mLessonListener.lessonSelect(lesson);
    }

    @Override
    public void showProgress() {
        /*progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);*/
    }

    @Override
    public void hideProgress() {
       /* progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);*/}
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LessonListener) {
            mLessonListener = (LessonListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement LessonListener");
        }
    }

}