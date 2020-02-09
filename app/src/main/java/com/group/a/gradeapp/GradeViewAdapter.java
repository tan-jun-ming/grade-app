package com.group.a.gradeapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.recyclerview.widget.RecyclerView;

// Adapted from https://developer.android.com/guide/topics/ui/layout/recyclerview
public class GradeViewAdapter extends RecyclerView.Adapter<GradeViewAdapter.GradeViewHolder> {
    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class GradeViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public RelativeLayout layout;
        public GradeViewHolder(RelativeLayout v) {
            super(v);
            layout = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public GradeViewAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public GradeViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gradeview_item, parent, false);

        GradeViewHolder vh = new GradeViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(GradeViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ((TextView)holder.layout.findViewById(R.id.gradeviewname)).setText(mDataset[position]);
        ((TextView)holder.layout.findViewById(R.id.gradeviewnum)).setText("50 million %");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}