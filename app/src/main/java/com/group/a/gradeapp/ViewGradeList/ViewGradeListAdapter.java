package com.group.a.gradeapp.ViewGradeList;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.group.a.gradeapp.R;
import com.group.a.gradeapp.utils;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

// Adapted from https://developer.android.com/guide/topics/ui/layout/recyclerview
public class ViewGradeListAdapter extends RecyclerView.Adapter<ViewGradeListAdapter.GradeViewHolder> {
    private RecyclerItemClickListener listener;
    private ArrayList<ViewGradeListItem> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class GradeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case

        public RelativeLayout layout;
        private RecyclerItemClickListener listener;

        public GradeViewHolder(RelativeLayout v, RecyclerItemClickListener l) {
            super(v);
            layout = v;
            listener = l;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ViewGradeListAdapter(RecyclerItemClickListener l) {
        mDataset = new ArrayList<ViewGradeListItem>();
        listener = l;
    }

    public void update(ArrayList<ViewGradeListItem> newdata) {
        mDataset.clear();
        mDataset.addAll(newdata);

        notifyDataSetChanged();
    }


    // Create new views (invoked by the layout manager)
    @Override
    public GradeViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gradeview_item, parent, false);

        GradeViewHolder vh = new GradeViewHolder(v, listener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(GradeViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        TextView item_name = holder.layout.findViewById(R.id.gradeviewname);
        TextView item_grade = holder.layout.findViewById(R.id.gradeviewnum);

        ViewGradeListItem item = mDataset.get(position);

        if (position % 2 == 0){
            holder.layout.setBackgroundColor(Color.LTGRAY);
        } else {
            holder.layout.setBackgroundColor(Color.WHITE);

        }

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) item_name.getLayoutParams();
        if (item.is_category){
            item_name.setTypeface(null, Typeface.BOLD);
            params.leftMargin = utils.dp_to_pixels(20);
        } else {
            item_name.setTypeface(null, Typeface.NORMAL);
            params.leftMargin = utils.dp_to_pixels(40);
        }

        item_name.setText(item.name);

        String gradepercentage = item.grade == null ? "- %" : String.format("%.2f%%", item.grade) ;

        item_grade.setText(gradepercentage);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}