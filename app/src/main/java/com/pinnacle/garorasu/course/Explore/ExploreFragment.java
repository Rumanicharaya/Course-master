package com.pinnacle.garorasu.course.Explore;

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

import com.pinnacle.garorasu.course.R;
import com.pinnacle.garorasu.course.SubjectListener;


public class ExploreFragment extends Fragment implements ExploreView {

    private ExploreView mListener;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    public SubjectListener mSubjectListener;

    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.explore_recyclerView);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_explore_fragment);
        ExploreAdapter adapter = new ExploreAdapter(this,getContext());
        adapter.requstData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onSubjectClick(Subject subject) {
        mSubjectListener.subjectSelect(subject);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }


    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SubjectListener) {
            mSubjectListener = (SubjectListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SubjectListener");
        }
    }
}
