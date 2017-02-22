package com.pinnacle.garorasu.course.Lesson;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinnacle.garorasu.course.Explore.Subject;
import com.pinnacle.garorasu.course.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/18/2017.
 */

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> implements LessonAdapterView {

    private final Context context;
    private final ArrayList<Lesson> allLessons = new ArrayList<>();
    private final LessonPresenterView lessonPresenter;
    private final String color;

    public LessonAdapter(LessonView lessonView,Context context,String color){
        this.context = context;
        this.color = color;
        lessonPresenter = new LessonPresenter(this,lessonView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_list_item, parent, false);
        return new ViewHolder(v);

    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lesson lesson = allLessons.get(position);
        holder.mlessonserialno.setText(lesson.getSerialno());
        holder.mlessonTitle.setText(lesson.getTitle());
        holder.mlessondescription.setText(lesson.getLessonDescription());

    }

    @Override
    public int getItemCount() {
        return allLessons.size();
    }

    @Override
    public void addLesson(Lesson lesson) {
        allLessons.add(lesson);
        notifyItemInserted(allLessons.size()-1);
    }

    @Override
    public void requstLesson() {
        lessonPresenter.requestLesson();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mlessonTitle,mlessondescription,mlessonserialno;
        public View viewGroup;
        public ImageView mLessonImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mlessonserialno=(TextView)itemView.findViewById(R.id.lesson_serial_no);
            mlessonTitle = (TextView) itemView.findViewById(R.id.lesson_title);
            mlessondescription = (TextView) itemView.findViewById(R.id.lesson_brief);
            mlessonserialno.setBackgroundResource(R.drawable.circletextshapegreen);
            GradientDrawable g = (GradientDrawable) mlessonserialno.getBackground().getCurrent();
            g.setColor(Color.parseColor(color));
            //tabLayout.setBackgroundColor(Color.parseColor(color));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lessonPresenter.onLessonSelect(allLessons.get(getAdapterPosition()));

                }
            });

        }
    }
}
