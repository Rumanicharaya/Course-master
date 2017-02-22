package com.pinnacle.garorasu.course.Explore;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pinnacle.garorasu.course.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> implements ExploreAdapterView{
    private final Context context;
    private final ArrayList<Subject> allSubjects = new ArrayList<>();
    private final ExplorePresenterView explorePresenter;

    public ExploreAdapter(ExploreView exploreView,Context context){
        this.context = context;
        explorePresenter = new ExplorePresenter(this,exploreView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Subject subject = allSubjects.get(position);
        holder.mSubTitle.setText(subject.getTitle());
        holder.mSubBrief.setText(subject.getBrief());
        holder.viewGroup.setBackgroundColor(Color.parseColor(subject.getColor()));
        Picasso.with(context).load(subject.getImgUrl()).fit().centerCrop()
                .error(R.drawable.ic_menu_gallery)
                .into(holder.mSubImg);
    }

    @Override
    public int getItemCount() {
        return allSubjects.size();
    }

    @Override
    public void requstData() {
        explorePresenter.requestSubject();
    }

    @Override
    public void addSubject(Subject subject) {
        allSubjects.add(subject);
        notifyItemInserted(allSubjects.size()-1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewGroup viewGroup;
        public TextView mSubTitle,mSubBrief;
        public ImageView mSubImg;
        public ViewHolder(View itemView) {
            super(itemView);
            viewGroup = (ViewGroup) itemView.findViewById(R.id.explore_background);
            mSubTitle = (TextView) itemView.findViewById(R.id.explore_subject_title);
            mSubBrief = (TextView) itemView.findViewById(R.id.explore_subject_brief);
            mSubImg = (ImageView) itemView.findViewById(R.id.explore_subject_icon);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    explorePresenter.onSubjectSelect(allSubjects.get(getAdapterPosition()));
                   // Subject no=allSubjects.get(getAdapterPosition());
                }
            });
        }
    }
}