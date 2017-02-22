package com.pinnacle.garorasu.course.Practice;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinnacle.garorasu.course.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/18/2017.
 */

public class PracticeAdapter extends RecyclerView.Adapter<PracticeAdapter.ViewHolder> implements PracticeAdapterView {

    private final Context context;
    private final ArrayList<Practice> allPractice = new ArrayList<>();
    private final PracticePresenterView practicePresenter;
    private final String color;

    public PracticeAdapter(PracticeView practiceView,Context context,String color){
        this.context = context;
        this.color = color;
        practicePresenter =  new PracticePresenter(this,practiceView);
    }


    @Override
    public PracticeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.practice_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PracticeAdapter.ViewHolder holder, int position) {
       Practice practice = allPractice.get(position);
        holder.mpracticeSerialno.setText(practice.getSerialno());
        holder.mpracticeTitle.setText(practice.getTitle());
        holder.mpracticedescription.setText(practice.getpracticeDescription());

    }

    @Override
    public int getItemCount() {
        return allPractice.size();
    }

    @Override
    public void requstPractice() {
       practicePresenter.requestPractice();

    }

    @Override
    public void addPractice(Practice practice) {
        allPractice.add(practice);
        notifyItemInserted(allPractice.size()-1);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mpracticeSerialno,mpracticeTitle,mpracticedescription;
        public View viewGroup;
        public ImageView mPracticeImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mpracticeSerialno = (TextView) itemView.findViewById(R.id.practice_serial_no);
            mpracticeTitle = (TextView) itemView.findViewById(R.id.practice_title);
            mpracticedescription = (TextView) itemView.findViewById(R.id.practice_brief);
            mpracticeSerialno.setBackgroundResource(R.drawable.circletextshapepurple);
            GradientDrawable g = (GradientDrawable) mpracticeSerialno.getBackground().getCurrent();
            g.setColor(Color.parseColor(color));
            //tabLayout.setBackgroundColor(Color.pars
         //   mpracticeSerialno.setBackgroundColor(Color.parseColor(color));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    practicePresenter.onPracticeSelect(allPractice.get(getAdapterPosition()));

                }
            });
        }
    }
}
